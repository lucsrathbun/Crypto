package com.example.crypto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {
    fun getInstance(): Retrofit = Retrofit.Builder()
        .baseUrl("https://rest.coinapi.io")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

