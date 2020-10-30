package com.example.myapplication

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


class BookAdapter(
    private var list: List<Book>,
    private val itemClick: (Book) -> Unit,
    private val deleteClick: (kotlin.Int) -> Unit
) : RecyclerView.Adapter<BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: kotlin.Int): BookHolder =
        BookHolder.create(parent, itemClick, deleteClick)

    override fun onBindViewHolder(holder: BookHolder, position: kotlin.Int) =
        holder.bind(list[position])

    override fun onBindViewHolder(holder: BookHolder, position: kotlin.Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) super.onBindViewHolder(holder, position, payloads)
        else {
            (payloads[0] as? Bundle)?.also {
                holder.updateFromBundle(it)
            } ?: run { super.onBindViewHolder(holder, position, payloads) }
        }
    }

    override fun getItemCount(): kotlin.Int = list.size

    fun updateDataSource(list: List<Book>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun updateDataDiffUtils(newList: List<Book>) {
        val callback = BookListDiffCallback(list, newList)
        val result = DiffUtil.calculateDiff(callback, true)
        result.dispatchUpdatesTo(this)
        list = newList
    }

    fun deleteItemAt(index: kotlin.Int) {
        val newList = list as ArrayList<Book>
        newList.removeAt(index)
        updateDataDiffUtils(newList)
        notifyDataSetChanged()
    }

    public fun addItemAt(index: kotlin.Int, name: String, author: String) {
        val newList = list as ArrayList<Book>
        val lastBook = newList[newList.size - 1]
        val book = Book(lastBook.id + 1, name, author, "empty", R.drawable.ic_baseline_clear_24, R.drawable.ic_baseline_delete_24)
        newList.add(index, book)
        updateDataDiffUtils(newList)
    }
}