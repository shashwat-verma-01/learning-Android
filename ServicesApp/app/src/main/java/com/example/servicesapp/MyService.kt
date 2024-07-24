package com.example.servicesapp

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService : Service() {

    lateinit var mediaPlayer : MediaPlayer

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mediaPlayer = MediaPlayer.create(
            this,
            Settings.System.DEFAULT_RINGTONE_URI
        )
//        play the ringtone on loop
        mediaPlayer.isLooping

        mediaPlayer.start()

//        return value : returns an integer that represents the services's
//        behaviour regarding restarts
//        START_STICKY : the service should be restarted by the system if
//        it gets terminated, and it should try to re-deliver the last
//        intent that was used to start the service

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }
}