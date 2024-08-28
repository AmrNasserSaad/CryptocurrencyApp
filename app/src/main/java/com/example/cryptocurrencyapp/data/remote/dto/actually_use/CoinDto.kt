package com.example.cryptocurrencyapp.data.remote.dto.actually_use


import com.example.cryptocurrencyapp.domain.model.Coin
import com.google.gson.annotations.SerializedName

// this object from the api
data class CoinDto(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

// this fun to transform the "CoinDto" into "Coin data class" From model from (domain)
// for use it in the ui
fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}