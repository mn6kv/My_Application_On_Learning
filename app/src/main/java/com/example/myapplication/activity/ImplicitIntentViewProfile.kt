package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R

class ImplicitIntentViewProfile : AppCompatActivity() {

    private lateinit var edtAcceptNickName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent_view_profile)

        edtAcceptNickName = findViewById(R.id.edtAcceptNickName)

        val btnAcceptNickName = findViewById<Button>(R.id.btnAcceptNickName)
        btnAcceptNickName.setOnClickListener {
            val intent = Intent()
            intent.putExtra("NickName", edtAcceptNickName.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}