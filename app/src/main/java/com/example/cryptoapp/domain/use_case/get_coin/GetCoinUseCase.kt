package com.example.cryptoapp.domain.use_case.get_coin

import com.example.cryptoapp.common.Resource
import com.example.cryptoapp.data.remote.dto.toCoinDetail
import com.example.cryptoapp.domain.model.CoinDetail
import com.example.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetail = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coinDetail))
        }catch (e: HttpException){
            emit(Resource.Error(e.message ?: "An Unexpected Error occured"))
        }catch (e: IOException){
            emit(Resource.Error(e.message ?: "An Unexpected Error occured"))
        }
    }
}