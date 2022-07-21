package com.example.fetchfromapi.network

import com.example.fetchfromapi.models.ProductResponseModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dummyjson.com/"

interface ApiService {
    @GET("products")
    fun list(): Call<ProductResponseModel>
}

object Api {
    val retrofitService: ApiService by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }
}