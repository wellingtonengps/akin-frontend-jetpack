package com.example.akin.data

import android.content.Context
import com.example.akin.network.repository.UserRepository

interface AppContainer {
    val usersRepository: UsersRepository
}


class AppDataContainer(private val context: Context) : AppContainer {
    override val usersRepository: UsersRepository by lazy {
        OfflineUsersRepository(AkinDatabase.getDataBase(context).userDao())
    }
}