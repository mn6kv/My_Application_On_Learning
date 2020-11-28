package com.example.myapplication.forRecycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.Music

class MusicAdapter(
    private var music: List<Music>,
    private val clickLambda: (id: Int) -> Unit
) : RecyclerView.Adapter<MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder =
        MusicViewHolder.create(parent, clickLambda)

    override fun getItemCount(): Int = music.size

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(music[position])
    }
}