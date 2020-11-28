package com.example.myapplication.repository

import com.example.myapplication.R
import com.example.myapplication.models.Music

object MusicRepository {
    fun getMusicList() : ArrayList<Music> = arrayListOf(
        Music("3/w", "Syringe, Ghostie", R.raw.syringeghostie3w),
        Music("izzamuzzic", "Cold", R.raw.izzamuzziccold),
        Music("OBRAZKOBRA", "Iskra", R.raw.obrazkobra),
        Music("REDZED", "Gazoline", R.raw.redzedgazoline),
        Music("10AGE", "Anabioz", R.raw.tenageanabioz),
        Music("DeepHouse", "Track7", R.raw.zhu),
        Music("suicideboy$", "NOxugen", R.raw.suicideboysnoxygen),
        Music("Bones", "Okay,ButThisIsTheLastTime", R.raw.bonesokay)
    )
}