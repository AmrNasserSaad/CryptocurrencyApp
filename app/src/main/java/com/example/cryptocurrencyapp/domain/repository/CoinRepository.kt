package com.example.cryptocurrencyapp.domain.repository

import com.example.cryptocurrencyapp.data.remote.dto.actually_use.CoinDetailDto
import com.example.cryptocurrencyapp.data.remote.dto.actually_use.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto> // we write the object return from api (the dto)

    suspend fun getCoinById(coinId: String): CoinDetailDto // the object return from api (the dto)
}