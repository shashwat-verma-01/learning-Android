package com.example.drawingappkids

import android.app.Activity
import android.Manifest
import android.app.Dialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {

    private var drawingView: DrawingView? = null
    private var mImageButtonCurrentColor: ImageButton? = null

    val openGalleryLauncher : ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == RESULT_OK && result.data != null){
                val imageBackground: ImageView = findViewById(R.id.iv_background)

                imageBackground.setImageURI(result.data?.data)
            }
        }

    val requestPermission : ActivityResultLauncher<Array<String>> =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
            permissions ->
            permissions.entries.forEach{
                val permissionName = it.key
                val isGranted = it.value

                if(isGranted){
                    Toast.makeText(
                        this@MainActivity,
                        "Permission granted to read storage files.",
                        Toast.LENGTH_LONG
                    ).show()

                    val pickIntent = Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    openGalleryLauncher.launch(pickIntent)

                }else{
                    if(permissionName == Manifest.permission.MANAGE_EXTERNAL_STORAGE){
                        Toast.makeText(
                            this@MainActivity,
                            "Permission denied to read storage files.",
                            Toast.LENGTH_LONG
                        ).show()
                        val pickIntent = Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                        openGalleryLauncher.launch(pickIntent)
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawingView = findViewById(R.id.drawingView)
        drawingView?.setSizeForBrush(20.toFloat())

        val ib_brush: ImageButton = findViewById(R.id.ib_brush)
        ib_brush.setOnClickListener() {
            showBrushSizeChooserDialog()
        }
//        getShitDone()

        val ib_colors: ImageButton = findViewById(R.id.ib_colors)
        ib_colors.setOnClickListener {
            showColorChooserDialog()
        }

        val ib_eraser: ImageButton = findViewById(R.id.ib_eraser)
        ib_eraser.setOnClickListener {
            drawingView?.setColor("#ffffff")
        }

        val ib_undo: ImageButton = findViewById(R.id.ib_undo)
        ib_undo.setOnClickListener {
            drawingView?.onCLickUndo()
        }

        val ib_gallery: ImageButton = findViewById(R.id.ib_gallery)
        ib_gallery.setOnClickListener {
            requestStoragePermission()
        }
    }

    private fun showColorChooserDialog() {
        val colorDialog = Dialog(this)
        colorDialog.setContentView(R.layout.color_palette_layout)
        colorDialog.setTitle("Choose color : ")
        colorDialog.show()
    }

    private fun showBrushSizeChooserDialog() {
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Brush size : ")
        val XsmallBtn = brushDialog.findViewById<ImageButton>(R.id.ib_Xsmall_brush)
        val smallBtn = brushDialog.findViewById<ImageButton>(R.id.ib_small_brush)
        val mediumBtn = brushDialog.findViewById<ImageButton>(R.id.ib_medium_brush)
        val largeBtn = brushDialog.findViewById<ImageButton>(R.id.ib_large_brush)
        val XlargeBtn = brushDialog.findViewById<ImageButton>(R.id.ib_Xlarge_brush)
        XsmallBtn.setOnClickListener {
            drawingView?.setSizeForBrush(5.toFloat())
            brushDialog.dismiss()
        }
        smallBtn.setOnClickListener {
            drawingView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }
        mediumBtn.setOnClickListener {
            drawingView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }
        largeBtn.setOnClickListener {
            drawingView?.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }
        XlargeBtn.setOnClickListener {
            drawingView?.setSizeForBrush(40.toFloat())
            brushDialog.dismiss()
        }
        brushDialog.show()
    }

    fun paintClicked(view: View) {
        Toast.makeText(this@MainActivity, "clicked", Toast.LENGTH_LONG).show()
        var mImageButtonCurrentColor = view as ImageButton
        mImageButtonCurrentColor.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.pallete_pressed
            )
        )
        val colorTag = mImageButtonCurrentColor.tag.toString()
        drawingView?.setColor(colorTag)
    }

    private fun requestStoragePermission(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && shouldShowRequestPermissionRationale(Manifest.permission.MANAGE_EXTERNAL_STORAGE
        )){
            showRationaleDialog("KIDS DRAWING APP",
                "Kids Drawing App " + "needs to Access Your External Storage")
            val pickIntent = Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            openGalleryLauncher.launch(pickIntent)
        }else{
            requestPermission.launch(arrayOf(
                Manifest.permission.MANAGE_EXTERNAL_STORAGE
                //TODO - Add writing external storage permission
            ))
        }
    }

    private fun showRationaleDialog(
        title: String,
        message: String
    ) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
        builder.create().show()
    }
}
