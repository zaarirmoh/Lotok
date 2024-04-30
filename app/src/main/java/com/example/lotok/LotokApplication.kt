package com.example.lotok

import android.app.Application
import com.example.lotok.data.AppContainer
import com.example.lotok.data.DefaultAppContainer

class LotokApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}