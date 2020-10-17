package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.myapplication.Book
import com.example.myapplication.BookAdapter
import com.example.myapplication.BookList
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_book_list.*

class BookListActivity : AppCompatActivity() {

    private var adapter: BookAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        adapter = BookAdapter(BookList.getBooks()) {

            val book: Book = it
            val intent = Intent(this, BookInfoActivity::class.java)
            intent.putExtra("id", book.id)
            startActivity(intent)

        }
        rv_book.adapter = adapter

        rv_book.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        swipe.setOnRefreshListener {
            adapter?.updateDataSource(BookList.getBooks())
            swipe.isRefreshing = false
            rv_book.adapter = adapter
        }
    }
}