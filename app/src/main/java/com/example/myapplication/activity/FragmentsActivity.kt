package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.fragments.*

class FragmentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        showFragment(StartBlankFragment())

        val iv1 = findViewById<ImageView>(R.id.ivLikeBottomNavigation1)
        iv1.setOnClickListener {
            showFragment(BlankFragment())
        }

        val iv2 = findViewById<ImageView>(R.id.ivLikeBottomNavigation2)
        iv2.setOnClickListener {
            showFragment(BlankFragment2())
        }

        val iv3 = findViewById<ImageView>(R.id.ivLikeBottomNavigation3)
        iv3.setOnClickListener {
            showFragment(BlankFragment3())
        }

        val iv4 = findViewById<ImageView>(R.id.ivLikeBottomNavigation4)
        iv4.setOnClickListener {
            showFragment(BlankFragment4())
        }

        val iv5 = findViewById<ImageView>(R.id.ivLikeBottomNavigation5)
        iv5.setOnClickListener {
            showFragment(BlankFragment5())
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
    }
}