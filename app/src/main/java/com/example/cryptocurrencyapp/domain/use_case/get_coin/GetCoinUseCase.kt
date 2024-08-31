package com.example.cryptocurrencyapp.domain.use_case.get_coin

import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.data.remote.dto.actually_use.toCoinDetail
import com.example.cryptocurrencyapp.domain.model.CoinDetail
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository // actually this repo depends on api and api depends on retrofit  but dagger handle it
) {
    // operator for the class has a one fun to use
    // Flow<Resource<List>> for handle the state and Flow mean that you have a state متغيره (loadind or success or error)
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> =
        flow {  // that means return flow
            try {
                emit(Resource.Loading()) // for loading state

                val coin = repository.getCoinById(coinId)
                    .toCoinDetail() // transform from coinDetailDto to coinDetail
                emit(Resource.Success(coin))

            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            } catch (e: IOException) {
                emit(Resource.Error("Couldn't reach server. Check your internet connection."))
            }
        }
}