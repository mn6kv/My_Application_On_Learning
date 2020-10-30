package com.example.myapplication.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.myapplication.Book
import com.example.myapplication.BookAdapter
import com.example.myapplication.BookList
import com.example.myapplication.R
import com.example.myapplication.activity.BookInfoActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_btm_storage.*

class BtmFragmentStorage : Fragment() {

    private var adapter: BookAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_btm_storage, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var index : kotlin.Int? = null
        adapter = BookAdapter(BookList.getBooks(),
            {

            val book: Book = it
            val intent = Intent(this.context, BookInfoActivity::class.java)
            intent.putExtra("id", book.id)
            startActivity(intent)

            },
            {
                i: kotlin.Int ->
            index = i
            adapter?.deleteItemAt(i)
        })

        rv_book_storage.adapter = adapter
        rv_book_storage.addItemDecoration(
            DividerItemDecoration(
                this.context,
                DividerItemDecoration.VERTICAL
            )
        )

        swipe_storage.setOnRefreshListener {
            adapter?.updateDataDiffUtils(BookList.getBooks())
            swipe_storage.isRefreshing = false
        }

//        fabAddStorage.setOnClickListener {
//            val dialog = this.context?.let { it1 -> Dialog(it1) }
//            dialog?.setContentView(R.layout.dialogue_add_book)
//            dialog?.show()
//        }

        fabAddStorage.setOnClickListener {
            fragmentManager?.let { it1 -> AddBookDialog.show(it1, positiveAction = { name, author, position ->
                adapter!!.addItemAt(position, name, author)
                Snackbar.make(it, "Success data from dialog $name", Snackbar.LENGTH_LONG).show()
            }, negativeAction = {
                Snackbar.make(it, "Canceled", Snackbar.LENGTH_SHORT).show()
            })
            }
        }

    }

}