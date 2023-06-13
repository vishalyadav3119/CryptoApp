package com.example.cryptoapp.presentation.coin_detail

import com.example.cryptoapp.domain.model.Coin
import com.example.cryptoapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error:String = ""
)