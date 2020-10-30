package com.example.myapplication

import kotlin.Int

data class Book(
    val id: Int,
    var name: String,
    var author: String,
    val desc: String,
    val photo: Int,
    val deleteBtn: Int
){
}