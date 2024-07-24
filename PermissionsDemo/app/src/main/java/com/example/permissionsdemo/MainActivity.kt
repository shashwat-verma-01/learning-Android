package com.example.permissionsdemo

import android.Manifest
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private val cameraAndLocationResultLauncher: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()){
               permissions ->
                permissions.entries.forEach{
                    val permissionName = it.key
                    val isGranted = it.value
                    if(isGranted){
                        if(permissionName == Manifest.permission.ACCESS_FINE_LOCATION){
                            Toast.makeText(this, "Permission granted for location",Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(this, "Permission granted for camera",Toast.LENGTH_LONG).show()
                        }
                    }else{
                        if(permissionName == Manifest.permission.ACCESS_FINE_LOCATION){
                            Toast.makeText(this, "Permission denied for location",Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(this, "Permission denied for camera",Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_camera_permission : Button = findViewById(R.id.btn_camera_permission)
        btn_camera_permission.setOnClickListener{
            requestPermission()
        }

        val changeActivity : Button = findViewById(R.id.changeActivity)
        changeActivity.setOnClickListener{
            val intent = Intent(this, PermissionsAndSnackBar::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun showRationaleDialog(title : String, message : String){
        val builder : AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton("Cancel"){dialog, _-> dialog.dismiss()
            }
        builder.create().show()
    }

    private fun requestPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
            showRationaleDialog("Permission Demo requires camera access.",
                "Camera cannot be used because user denied access.")
        }
        else{
            cameraAndLocationResultLauncher.launch(arrayOf(Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION))
        }
    }

}