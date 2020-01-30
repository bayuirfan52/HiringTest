package com.bayuirfan.hiring.pinterestimage.api

import com.bayuirfan.hiring.pinterestimage.model.Data
import com.bayuirfan.hiring.pinterestimage.model.ResultArray
import retrofit2.http.GET

interface ApiService {

    @GET("v3/pidgets/boards/yogajunianto/mu-hd/pins/")
    suspend fun getPins() : ResultArray<Data>
}