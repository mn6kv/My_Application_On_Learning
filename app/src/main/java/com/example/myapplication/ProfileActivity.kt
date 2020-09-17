package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class ProfileActivity : AppCompatActivity() {

    lateinit var rbMale: RadioButton
    lateinit var rbFemale: RadioButton
    private lateinit var edtSecName: EditText
    private lateinit var edtName: EditText
    private lateinit var edtOtchestvo: EditText
//    private lateinit var btnEditProfile: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar);
/*        supportActionBar?.homeAsUpIndicator = R.drawable.ic_baseline_clear_24
        supportActionBar?.displayHomeAsUpEnabled = true*/
        //toolbar!!.title = "Личные данные"
        //toolbar.setDisplayHomeAsUpEnabled(true)

        edtSecName = findViewById<EditText>(R.id.edtSecondName)
        edtName = findViewById<EditText>(R.id.edtName)
        edtOtchestvo = findViewById<EditText>(R.id.edtOtchestvo)

        rbMale = findViewById(R.id.rbMale)
        rbFemale = findViewById(R.id.rbFemale)

//        btnEditProfile = findViewById(R.id.btnEditProfile)

        edtBlock(edtSecName)
        edtBlock(edtName)
        edtBlock(edtOtchestvo)

/*        btnEditProfile.setOnClickListener{
            edtUnblock(edtSecName)
            edtUnblock(edtName)
            edtUnblock(edtOtchestvo)
        }*/
    }

    fun edtBlock(edt: EditText) {
        edt.isFocusable = false
        edt.isLongClickable = false
    }

    fun edtUnblock(edt: EditText) {
        edt.isFocusable = true
        edt.isLongClickable = true
    }

/*    override fun onCheckedChanged(btn: CompoundButton, ischecked: Boolean) {
        if (ischecked)

    }*/


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}