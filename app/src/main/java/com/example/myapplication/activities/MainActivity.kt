package com.example.myapplication.activities

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.forRecycler.OnFragmentListener
import com.example.myapplication.fragments.BlankFragment
import com.example.myapplication.services.MusicService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnFragmentListener {

    private var musicService : MusicService? = null
    private var mBound = false
    private var isBlankFragmentshowed = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindToService()

        hideFragment(BlankFragment.newInstance())

        btn_playlist.setOnClickListener {
            if (!isBlankFragmentshowed) {
                showFragment(BlankFragment.newInstance())
                isBlankFragmentshowed = true
            } else if (isBlankFragmentshowed) {
                hideFragment(BlankFragment.newInstance())
                isBlankFragmentshowed = false
            }
        }

        tv_play.setOnClickListener {
            musicService?.play(R.raw.syringeghostie3w)
        }

        tv_pause.setOnClickListener {
            musicService?.pause()
        }
    }

//    private fun bindToService() {
//        val mConnection = object : ServiceConnection {
//            override fun onServiceConnected(className: ComponentName?, service: IBinder?) {
//                Log.d("LOG_TAG", "MainAct service connected")
//                binder = service as? MusicService.LocalBinder
//                musicService = binder?.getService()
//            }
//
//            override fun onServiceDisconnected(p0: ComponentName?) {
//                Log.d("LOG_TAG", "MainAct service disconnected")
//                binder = null
//                musicService = null
//            }
//        }
//    }

    private fun bindToService() {
        if (!mBound) {
            val intent = Intent(this, MusicService::class.java)
            bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
        }
    }

    private val mConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, serviceB: IBinder?) {
            val binder: MusicService.LocalBinder = serviceB as MusicService.LocalBinder
            musicService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mBound = false
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
    }

    private fun hideFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().hide(fragment).commit()
    }

    override fun onFragmentListener(music: Int) {
        musicService?.play(music)
    }
}