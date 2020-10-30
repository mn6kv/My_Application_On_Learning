package com.example.myapplication.bookViewPager

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class VPBookAdapter(private var list: List<Int>): RecyclerView.Adapter<VPBookHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: kotlin.Int): VPBookHolder =
        VPBookHolder.create(parent)

    override fun onBindViewHolder(holder: VPBookHolder, position: kotlin.Int) =
        holder.bind(list[position])

    override fun getItemCount(): kotlin.Int = list.size
}