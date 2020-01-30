package com.bayuirfan.hiring.pinterestimage.helper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.bayuirfan.hiring.pinterestimage.model.Result

suspend fun <T> safeApiCall(apiCall : suspend() -> T): Result<T> {
    return withContext(Dispatchers.IO){
        try {
            Result.Success(apiCall.invoke())
        }  catch (t: Throwable){
            Result.Error(t)
        }
    }
}