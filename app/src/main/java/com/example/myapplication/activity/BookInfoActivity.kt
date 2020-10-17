package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.BookList
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_book_info.*

class BookInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_info)

        val id = intent.getSerializableExtra("id")

        val bookList = BookList.getBooks()
        for (i in 0 until bookList.size) {
            if (bookList[i].id == id) {
                tv_name_profile.text = bookList[i].name
                tv_author_profile.text = bookList[i].author
                tv_desc_profile.text = bookList[i].desc
                img_book_profile.setImageResource(bookList[i].photo)
                break
            }
        }
    }
}