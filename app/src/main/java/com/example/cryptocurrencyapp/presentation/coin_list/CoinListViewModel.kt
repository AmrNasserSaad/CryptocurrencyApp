package com.example.cryptocurrencyapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

// this annotation means -> hilt will handle the depends of ui from VM
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    // private  -> cuz we only use it in VM to make it cannot be modifiable in the ui (composable fun's )
    private val _state = mutableStateOf(CoinListState())

    // public -> cuz we use it in the ui (composable fun's )
    val state: State<CoinListState> = _state

    init {
        // init means -> we not need to make an instance of the VM Class cuz  we use init (:
        // just we call the VM Class it will initialize this fun
        getCoins()
    }

    private fun getCoins() {

        // cuz we use operator fun so we can call invoke fun like this cuz the class GetCoinsUseCase have this only fun (invoke)
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {

                    // i told him is Success return the data (Coins List)
                    // ?: (elvis operator) -->  if the (result.data) = null return emptyList() if not return the data
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }

                is Resource.Error -> {

                    _state.value = CoinListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

                is Resource.Loading -> {

                    _state.value = CoinListState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope) // we must put the onEach fun in the coroutine scope cuz it is a flow ( flow -> async)

    }

}