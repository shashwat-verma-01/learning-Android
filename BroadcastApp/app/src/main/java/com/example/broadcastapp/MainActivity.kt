package com.example.broadcastapp

import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var airplaneModeReciever : ApplicationModeReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var intentFilter : IntentFilter = IntentFilter("android.intent.action.AIRPLANE_MODE")

        var airplaneModeReciever = ApplicationModeReceiver()
        registerReceiver(airplaneModeReciever, intentFilter)
    }

    override fun onDestroy() {
        unregisterReceiver(airplaneModeReciever)
        super.onDestroy()
    }
}