package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.myapplication.R

class ViewProfileActivity : AppCompatActivity() {

    private lateinit var tvSecName: TextView
    private lateinit var tvName: TextView
    private lateinit var tvOtchestvo: TextView
    private lateinit var tvBirthdate: TextView
    private lateinit var tvGrazhd: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_profile)

        val secName = intent.getStringExtra("secName")
        val name = intent.getStringExtra("name")
        val otchestvo = intent.getStringExtra("otchestvo")
        val birthdate = intent.getStringExtra("birthdate")
        val grazhd = intent.getStringExtra("grazhd")

        tvSecName = findViewById(R.id.tvSecondName)
        tvName = findViewById(R.id.tvName)
        tvOtchestvo = findViewById(R.id.tvOtchestvo)
        tvBirthdate = findViewById(R.id.tvBirthDate)
        tvGrazhd = findViewById(R.id.tvGrazhdanstvo)

        tvSecName.text = secName
        tvName.text = name
        tvOtchestvo.text = otchestvo
        tvBirthdate.text = birthdate
        tvGrazhd.text = grazhd

        val btnToMain = findViewById<Button>(R.id.btnViewProfileToMain)
        btnToMain.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}