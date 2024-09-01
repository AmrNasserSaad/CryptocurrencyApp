package com.example.cryptocurrencyapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// this class is just to inform dagger hilt about the context of the application
// next step : go to manifest and add   android:name=".CoinApplication" in application tag
@HiltAndroidApp
class CoinApplication : Application()
