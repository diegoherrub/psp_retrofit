package com.psp.retrofit.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    //private const val BASE_URL_API = "http://127.0.0.1:8080/"
    private const val BASE_URL_API = "http://192.168.32.1:8080/"

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
