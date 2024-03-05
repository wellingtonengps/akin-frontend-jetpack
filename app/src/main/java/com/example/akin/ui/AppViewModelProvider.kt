package com.example.akin.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.akin.AkinApplication
import com.example.akin.network.repository.UserRepository
import com.example.akin.ui.signIn.SignInViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            SignInViewModel(akinApplication().container.usersRepository, UserRepository())
        }
    }
}

fun CreationExtras.akinApplication(): AkinApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as AkinApplication)