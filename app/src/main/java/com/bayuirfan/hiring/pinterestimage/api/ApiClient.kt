package com.bayuirfan.hiring.pinterestimage.api

import com.bayuirfan.hiring.pinterestimage.BuildConfig
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val gson = GsonBuilder()
        .create()
    private val okHttpBuilder = OkHttpClient.Builder()
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())

    fun getClient(): ApiService{
        val client = okHttpBuilder.build()
        val retrofit = retrofitBuilder.client(client).build()
        return retrofit.create(ApiService::class.java) as ApiService
    }
}