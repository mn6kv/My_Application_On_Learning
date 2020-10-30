package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.util.Keys
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_book.*

class BookHolder(

    override val containerView: View,
    private val itemClick: (Book) -> Unit,
    private val deleteClick: (kotlin.Int) -> Unit

) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private var book: Book? = null

    init {
        itemView.setOnClickListener {
            book?.also(itemClick)
        }
    }

    fun bind(book: Book) {
        this.book = book
        tv_name.text = book.name
        tv_author.text = book.author
        btnDeleteBook.setImageResource(book.deleteBtn)
        btnDeleteBook.setOnClickListener {
            deleteClick(layoutPosition)
        }
    }

    fun updateFromBundle(bundle: Bundle?) {
        if (bundle?.containsKey(Keys.KEY_NAME) == true) {
            bundle.getString(Keys.KEY_NAME).also {
                tv_name.text = it
            }
        }

        if (bundle?.containsKey(Keys.KEY_AUTHOR) == true) {
            bundle.getString(Keys.KEY_AUTHOR).also {
                tv_author.text = it
            }
        }
    }

    companion object {
        fun create(parent: ViewGroup, itemClick: (Book) -> Unit, deleteClick: (kotlin.Int) -> Unit): BookHolder =
            BookHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false),
                itemClick, deleteClick
            )
    }
}
