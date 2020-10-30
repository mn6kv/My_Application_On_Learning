package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.bookViewPager.VPBookAdapter
import com.example.myapplication.util.Keys
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.book_cardview_visibility.*


class BookVisibilityHolder(
    override val containerView: View,
    private var adapter: VPBookAdapter
):
RecyclerView.ViewHolder(containerView), LayoutContainer {

    private var book: Book? = null

    fun bind(book: Book) {
        this.book = book
        tv_cv_bookName.text = book.name
        tv_cv_bookAuthor.text = book.author

//        iv_cv_bookImage.setImageResource(book.photo)
    }

    fun updateFromBundle(bundle: Bundle?) {
        if (bundle?.containsKey(Keys.KEY_NAME) == true) {
            bundle.getString(Keys.KEY_NAME).also {
                tv_cv_bookName.text = it
            }
        }

        if (bundle?.containsKey(Keys.KEY_AUTHOR) == true) {
            bundle.getString(Keys.KEY_AUTHOR).also {
                tv_cv_bookAuthor.text = it
            }
        }

        if (bundle?.containsKey(Keys.KEY_PHOTO) == true) {
            bundle.getInt(Keys.KEY_PHOTO).also {
//                iv_cv_bookImage.setImageResource(it)
            }
        }
    }

    companion object {
        fun create (parent: ViewGroup, adapter: VPBookAdapter): BookVisibilityHolder =
            BookVisibilityHolder(
                LayoutInflater.from(parent.context)
                .inflate(R.layout.book_cardview_visibility, parent, false), adapter)
    }
}