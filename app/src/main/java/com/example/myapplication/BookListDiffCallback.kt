package com.example.myapplication

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.util.Keys

class BookListDiffCallback : DiffUtil.Callback {

    private lateinit var oldList: List<Book>
    private lateinit var newList: List<Book>

    constructor(oldList: List<Book>, newList: List<Book>) {
        this.oldList = oldList
        this.newList = newList
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: kotlin.Int, newItemPosition: kotlin.Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: kotlin.Int, newItemPosition: kotlin.Int) =
        oldList[oldItemPosition].equals(newList[newItemPosition])

    override fun getChangePayload(oldItemPosition: kotlin.Int, newItemPosition: kotlin.Int): Any? {

        val oldBook = oldList[oldItemPosition]
        val newBook = newList[newItemPosition]
        val diffBundle = Bundle()

        if (oldBook.name != newBook.name)
            diffBundle.putString(Keys.KEY_NAME, newBook.name)

        if (oldBook.author != newBook.author)
            diffBundle.putString(Keys.KEY_AUTHOR, newBook.author)

//        if (oldBook.desc != newBook.desc)
//            diffBundle.putString(Keys.KEY_DESC, newBook.desc)
//
//        if (oldBook.photo != newBook.photo)
//            diffBundle.putInt(Keys.KEY_PHOTO, newBook.photo)

        if (diffBundle.size() == null) return null
        return diffBundle
    }
}