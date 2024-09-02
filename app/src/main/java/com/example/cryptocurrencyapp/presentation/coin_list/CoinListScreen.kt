package com.example.cryptocurrencyapp.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocurrencyapp.common.ScreenNavigation
import com.example.cryptocurrencyapp.presentation.coin_list.components.CoinListItem


@Composable
fun CoinListScreen(
    navController: NavController,// to navigate to coin details screen
    viewModel: CoinListViewModel = hiltViewModel() // take an instance from the VM
) {
    val state = viewModel.state.value // to easily using

    Box(modifier = Modifier.fillMaxSize()) {
        // handle success state
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            // coins  = success
            items(state.coins) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        // navigate to CoinDetailScreen with parameter (coin.id) and VM will handle this id
                        navController.navigate(ScreenNavigation.CoinDetailScreen.route + "/${coin.id}")
                    }
                )
            }
        }
        // handle error state
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = Color.Green,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        // handle loading state
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}