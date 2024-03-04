package com.example.akin

import android.app.Application
import com.example.akin.data.AppContainer
import com.example.akin.data.AppDataContainer

class AkinApplication : Application() {

    lateinit var  container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
