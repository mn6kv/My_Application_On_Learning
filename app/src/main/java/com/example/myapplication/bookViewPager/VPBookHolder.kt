package com.example.myapplication.bookViewPager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_book_viewpager.*

class VPBookHolder(override val containerView: View):
    RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(img: kotlin.Int) {
        iv_book_vpager_img.setImageResource(img)
    }

    companion object {
        fun create(parent: ViewGroup): VPBookHolder =
            VPBookHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_book_viewpager, parent, false)
            )
    }
}