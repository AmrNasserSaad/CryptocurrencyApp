package com.example.cryptocurrencyapp.data.repository

import com.example.cryptocurrencyapp.data.remote.CoinPaprikaApi
import com.example.cryptocurrencyapp.data.remote.dto.actually_use.CoinDetailDto
import com.example.cryptocurrencyapp.data.remote.dto.actually_use.CoinDto
import com.example.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi // actually this api depends on retrofit but dagger handle it
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {

        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {

        return api.getCoinById(coinId)
    }

}