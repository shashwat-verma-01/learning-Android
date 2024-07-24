package com.example.broadcastapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ApplicationModeReceiver : BroadcastReceiver() {
//    Broadcast receiver : allows the registration and handling
//    of system-wide broadcast

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action != null
            && intent.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            var isAirplaneModeOn : Boolean = intent.getBooleanExtra("state", false)
            if(isAirplaneModeOn){
                Toast.makeText(context,
                    "Airplane Mode is On",
                    Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,
                    "Airplane Mode is Off",
                    Toast.LENGTH_LONG).show()
            }
        }
    }
}