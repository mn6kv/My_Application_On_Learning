package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.util.RequestCode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var tvNickName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNickName = findViewById<TextView>(R.id.tvNickName)
        val button = findViewById<Button>(R.id.btnGoToProfile)
//        var leopard = Leopard("1", 110, 0.5f, 50)
        button.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        val btnNickName = findViewById<Button>(R.id.btnSetNickname)
        btnNickName.setOnClickListener {
            val intent = Intent("MyApplication.app.ImplicitIntentViewProfile")
            startActivityForResult(intent, RequestCode.REQUEST_CODE_NICKNAME)
        }

        btnGoToFragmets.setOnClickListener {
            val intent = Intent(this, FragmentsActivity::class.java)
            startActivity(intent)
        }

        btnGotToList.setOnClickListener {
            val intent = Intent(this, BookListActivity::class.java)
            startActivity(intent)
        }

        btnGoToBtmNavigation.setOnClickListener {
            val intent = Intent(this, BtmNavActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val nickName = data?.getStringExtra("NickName")
            tvNickName.text = "Hello, $nickName!"
        }
        else Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }


}