package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BookAdapter(
    private var list: List<Book>,
    private val itemClick: (Book) -> Unit
) : RecyclerView.Adapter<BookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder =
        BookHolder.create(parent, itemClick)

    override fun onBindViewHolder(holder: BookHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    fun updateDataSource(list: List<Book>) {
        this.list = list
        notifyDataSetChanged()
    }
}