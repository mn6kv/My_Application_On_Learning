package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.bookViewPager.VPBookAdapter
import com.example.myapplication.util.ImageList

class BookVisibilityAdapter(context: Context, private var bookList: List<Book>, private var adapter: VPBookAdapter):
RecyclerView.Adapter<BookVisibilityHolder>() {

    private val imgList = ImageList.getImgs()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: kotlin.Int): BookVisibilityHolder {
        return BookVisibilityHolder.create(parent, adapter!!)
    }

    override fun onBindViewHolder(holder: BookVisibilityHolder, position: kotlin.Int) =
        holder.bind(bookList[position])

    override fun onBindViewHolder(holder: BookVisibilityHolder, position: kotlin.Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) super.onBindViewHolder(holder, position, payloads)
        else {
            (payloads[0] as? Bundle)?.also {
                holder.updateFromBundle(it)
            } ?: run { super.onBindViewHolder(holder, position, payloads) }
        }
    }

    override fun getItemCount(): kotlin.Int = bookList.size

    fun updateDataDiffUtils(newList: List<Book>) {
        val callback = BookListDiffCallback(bookList, newList)
        val result = DiffUtil.calculateDiff(callback, true)
        result.dispatchUpdatesTo(this)
        bookList = newList
    }
}