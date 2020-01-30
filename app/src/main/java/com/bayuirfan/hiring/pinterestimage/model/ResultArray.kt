package com.bayuirfan.hiring.pinterestimage.model

data class ResultArray<T> (
    val status: String,
    val code: Int,
    val data: T
)