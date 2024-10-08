package com.example.cryptocurrencyapp.domain.model

// to use in ui
data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
