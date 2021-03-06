package com.bayuirfan.hiring.pinterestimage.model

sealed class Result<out T> {
    data class Success<out T>(val data : T): Result<T>()
    data class Error(val throwable: Throwable) : Result<Nothing>()
}