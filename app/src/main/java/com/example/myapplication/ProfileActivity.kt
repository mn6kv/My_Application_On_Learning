package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class ProfileActivity : AppCompatActivity() {

    lateinit var rbMale: RadioButton
    lateinit var rbFemale: RadioButton
    private lateinit var edtSecName: EditText
    private lateinit var edtName: EditText
    private lateinit var edtOtchestvo: EditText
    private lateinit var edtBirthdate: EditText
    private var flagBtnEditProfile: Boolean = false
    private lateinit var edtGrazhd: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(toolbar);
/*        supportActionBar?.homeAsUpIndicator = R.drawable.ic_baseline_clear_24
        supportActionBar?.displayHomeAsUpEnabled = true*/
        //toolbar!!.title = "Личные данные"
        //toolbar.setDisplayHomeAsUpEnabled(true)

        val intent = Intent(this, MainActivity::class.java)

/*        toolbar?.apply {
            setNavigationIcon(R.drawable.ic_baseline_clear_24)
            setNavigationOnClickListener{
                startActivity(intent)
            }
        }*/

        edtSecName = findViewById(R.id.edtSecondName)
        edtName = findViewById(R.id.edtName)
        edtOtchestvo = findViewById(R.id.edtOtchestvo)
        edtBirthdate = findViewById(R.id.edtBirthdate)
        edtGrazhd = findViewById(R.id.edtGrazhdanstvo)

        rbMale = findViewById(R.id.rbMale)
        rbFemale = findViewById(R.id.rbFemale)

        blockAll()

        val btnProfileEdit = findViewById<Button>(R.id.btnProfileEdit)
        btnProfileEdit.setOnClickListener{
            if (!flagBtnEditProfile) {
                unlockAll()
                flagBtnEditProfile = true
            }
            else {
                blockAll()
                flagBtnEditProfile = false
            }
        }

        val btnProfileBack = findViewById<Button>(R.id.btnBack3)
        btnProfileBack.setOnClickListener{
            onBackPressed()
        }

        val btnGoToView = findViewById<Button>(R.id.btnGoToViewProfile)
        btnGoToView.setOnClickListener{
            val intent = Intent(this, ViewProfileActivity::class.java)
            intent.putExtra("secName", edtSecName.text.toString())
            intent.putExtra("name", edtName.text.toString())
            intent.putExtra("otchestvo", edtOtchestvo.text.toString())
            intent.putExtra("birthdate", edtBirthdate.text.toString())
            intent.putExtra("grazhd", edtGrazhd.text.toString())
            startActivity(intent)
        }

//        val btnImplicitIntent = findViewById<Button>(R.id.btnimplicitIntent)
//        btnImplicitIntent.setOnClickListener{
//            val intent = Intent("MyApplication.app.ImplicitIntentViewProfile")
//            intent.putExtra("secName", edtSecName.text.toString())
//            intent.putExtra("name", edtName.text.toString())
//            intent.putExtra("otchestvo", edtOtchestvo.text.toString())
//            intent.putExtra("birthdate", edtBirthdate.text.toString())
//            intent.putExtra("grazhd", edtGrazhd.text.toString())
//            startActivity(intent)
//        }
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.toolbar_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.btnProfileBackTb -> {
//                val intent = Intent(this, MainActivity::class.java)
//                intent.putExtra("key",edtName.toString())
//                startActivity(intent)
//                finish()
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

    private fun block(edt: EditText) {
        edt.isFocusable = false
        edt.isLongClickable = false
    }

    private fun unlock(edt: EditText) {
        edt.isFocusable = true
        edt.isLongClickable = true
        edt.isFocusableInTouchMode = true
    }

    private fun block(rb: RadioButton) {
        rb.isEnabled = false
        rb.isClickable = false
    }

    private fun unlock(rb: RadioButton) {
        rb.isEnabled = true
        rb.isClickable = true
    }

    private fun blockAll() {
        block(edtSecName)
        block(edtName)
        block(edtOtchestvo)
        block(rbMale)
        block(rbFemale)
        block(edtBirthdate)
        block(edtGrazhd)
    }

    private fun unlockAll() {
        unlock(edtSecName)
        unlock(edtName)
        unlock(edtOtchestvo)
        unlock(rbMale)
        unlock(rbFemale)
        unlock(edtBirthdate)
        unlock(edtGrazhd)
    }

/*    override fun onCheckedChanged(btn: CompoundButton, ischecked: Boolean) {
        if (ischecked)

    }*/


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}