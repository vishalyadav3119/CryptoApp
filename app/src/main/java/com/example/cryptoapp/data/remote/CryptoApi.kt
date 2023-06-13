package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.remote.dto.CoinDetailDto
import com.example.cryptoapp.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>
    @GET("/v1/coins/{coin_id}")
    suspend fun getCoinById(@Path("coin_id") coinId:String): CoinDetailDto
}