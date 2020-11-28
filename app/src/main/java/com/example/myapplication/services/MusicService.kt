package com.example.myapplication.services

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Binder
import android.os.IBinder
import android.util.Log
import java.net.URI

class MusicService : Service() {

    private var mediaPlayer: MediaPlayer? = null

    inner class LocalBinder : Binder() {
        fun getService(): MusicService = this@MusicService
    }

    override fun onCreate() {
        super.onCreate()
        //mediaPlayer = MediaPlayer()
//        mediaPlayer.setAudioAttributes(
//            AudioAttributes.Builder()
//                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                .setUsage(AudioAttributes.USAGE_MEDIA)
//                .build()
//        )
    }

    override fun onBind(intent: Intent): IBinder = LocalBinder()

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }

    fun pause() {
        if (mediaPlayer?.isPlaying!!)
            mediaPlayer?.pause()
    }

    fun play(res: Int) {
        mediaPlayer?.stop()
        Log.e("Before Play", "Before Play")
        mediaPlayer = MediaPlayer.create(applicationContext, res)
        mediaPlayer?.start()
        Log.e("Play", "Play")
    }

//    fun setRes(uri: Uri) {
//        mediaPlayer.setDataSource(applicationContext, uri)
//        mediaPlayer.prepare()
//    }

    fun setRes(res: Int) {
        mediaPlayer = MediaPlayer.create(applicationContext, res)
    }
}
