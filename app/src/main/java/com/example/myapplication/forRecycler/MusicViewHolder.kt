package com.example.myapplication.forRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.Music
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_music.*

class MusicViewHolder (
    override val containerView: View,
    private val clickLambda: (id: Int) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private var music: Music? = null
//    private val tv_name = containerView.tv_name
//    private val tv_album = containerView.tv_album
    
    fun bind(music: Music) {
        this.music = music
        tv_name?.text = music.name
        tv_album?.text = music.author
        itemView.setOnClickListener {
            clickLambda.invoke(music.music)
        }
    }

    companion object {

        fun create(parent: ViewGroup, clickLambda: (id: Int) -> Unit) =
            MusicViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false),
                clickLambda
            )
    }
}