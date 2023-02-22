package com.example.crypto

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CryptoDataService {
    @GET("/v1/exchangerate/{asset_id_base}.json")
    fun getCryptoData(
        @Path("asset_id_base") asset_id_base: String,
        @Query("apiKey") apiKey: String) : Call<List<CryptoData>>
}