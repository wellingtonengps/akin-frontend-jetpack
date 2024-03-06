package com.example.akin.data

import android.content.Context
import com.example.akin.auth.data.OfflineUserRepository
import com.example.akin.auth.data.UserRepository

interface AppContainer {
    val userRepository: UserRepository
}


class AppDataContainer(private val context: Context) : AppContainer {
    override val userRepository: UserRepository by lazy {
        OfflineUserRepository(AkinDatabase.getDataBase(context).userDao())
    }
}