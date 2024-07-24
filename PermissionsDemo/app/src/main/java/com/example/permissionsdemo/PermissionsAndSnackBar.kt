package com.example.permissionsdemo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class PermissionsAndSnackBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permissions_and_snack_bar)
        val im_btn : ImageButton = findViewById(R.id.im_btn)
        im_btn.setOnClickListener{
            Snackbar.make(it, "You have clicked image button", Snackbar.LENGTH_LONG).show()
        }
        val btn1 : Button = findViewById(R.id.btn_1)
        btn1.setOnClickListener{
            alertDialogFunction()
        }
        val btn2 : Button = findViewById(R.id.btn_2)
        btn2.setOnClickListener{
            customDialogFunction()
        }
        val btn3 : Button = findViewById(R.id.btn_3)
        btn3.setOnClickListener{
            customProgressFunction()
        }
    }

    private fun alertDialogFunction(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("This is Alert Dialog. Used to show alerts")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("YES"){
            dialogInterface, which -> Toast.makeText(this, "Clicked YES", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("NO"){
            dialogInterface, which -> Toast.makeText(this, "Clicked NO", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        builder.setNeutralButton("CANCEL"){
            dialogInterface, which -> Toast.makeText(this, "Clicked CANCEL\nOeration Cancelled", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()
        }
        val alertDialog : AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun customDialogFunction(){
        val customDialog = Dialog(this)
        customDialog.setContentView(R.layout.dialog_custom)
        customDialog.findViewById<TextView>(R.id.submit).setOnClickListener{
            Toast.makeText(this,"Clicked SUBMIT", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }
        customDialog.findViewById<TextView>(R.id.cancel).setOnClickListener{
            Toast.makeText(this,"Clicked CANCEL", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun customProgressFunction(){
        val customProgressDialog = Dialog(this)
        customProgressDialog.setContentView(R.layout.progress_custom)
        customProgressDialog.show()
    }
}