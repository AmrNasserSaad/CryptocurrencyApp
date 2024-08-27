package com.example.cryptocurrencyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptocurrencyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    Text(text = "scscssc",modifier = Modifier.padding(padding))
                }
            }
        }
    }
}
