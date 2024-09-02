package com.example.cryptocurrencyapp.common

sealed class ScreenNavigation(val route: String) {
    data object CoinListScreen : ScreenNavigation("coin_list_screen")
    data object CoinDetailScreen : ScreenNavigation("coin_detail_screen")
}