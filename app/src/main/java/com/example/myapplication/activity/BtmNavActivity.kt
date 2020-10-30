package com.example.myapplication.activity

import android.app.Dialog
import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.fragments.BlankFragment
import com.example.myapplication.fragments.BtmFragmentStorage
import com.example.myapplication.fragments.BtmFragmentVisibiliti
import kotlinx.android.synthetic.main.activity_btm_nav.*

class BtmNavActivity : AppCompatActivity() {

    private lateinit var lastFrag: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_btm_nav)

        val firstFrag = BlankFragment()
        val secondFrag = BtmFragmentStorage()
        val thirdFrag = BtmFragmentVisibiliti()
        lastFrag = firstFrag

        supportFragmentManager.beginTransaction()
            .add(R.id.containerBtmNav, firstFrag)
            .add(R.id.containerBtmNav, secondFrag)
            .add(R.id.containerBtmNav, thirdFrag)
            .hide(secondFrag)
            .hide(thirdFrag)
            .commit()

        bnvRecycler.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.first -> {
                    changeFragment(firstFrag)
                    lastFrag = firstFrag
                    true
                }
                R.id.second -> {
                    changeFragment(secondFrag)
                    lastFrag = secondFrag
                    true
                }
                R.id.third -> {
                    changeFragment(thirdFrag)
                    lastFrag = thirdFrag
                    true
                }
                else -> false
            }
        }


    }

    private fun changeFragment(fragment: Fragment) {
        if (fragment != lastFrag)
            supportFragmentManager.beginTransaction()
                .hide(lastFrag)
                .show(fragment)
                .commit()
    }


}