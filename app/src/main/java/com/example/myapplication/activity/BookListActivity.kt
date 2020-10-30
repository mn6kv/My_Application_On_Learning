package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.BookAdapter

class BookListActivity : AppCompatActivity() {

    private var adapter: BookAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_book_list)
//
//        adapter = BookAdapter(BookList.getBooks(),
//            {
//
//                val book: Book = it
//                val intent = Intent(this.context, BookInfoActivity::class.java)
//                intent.putExtra("id", book.id)
//                startActivity(intent)
//
//            },
//            {
//                    i: Int ->
//                index = i
//                adapter?.deleteItemAt(i)
//            })
//        rv_book.adapter = adapter
//
//        rv_book.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
//
//        swipe.setOnRefreshListener {
//            adapter?.updateDataSource(BookList.getBooks())
//            swipe.isRefreshing = false
//            rv_book.adapter = adapter
//        }
//    }
    }
}