package com.example.akin.ui

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.akin.AkinApplication
import com.example.akin.auth.data.AuthRepository
import com.example.akin.auth.domain.SignInUseCase
import com.example.akin.auth.domain.SignUpUseCase
import com.example.akin.auth.domain.UserViewModel
import com.example.akin.auth.presentation.signIn.SignInViewModel
import com.example.akin.auth.presentation.signUp.SignUpViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            UserViewModel(
                akinApplication().container.userRepository
            )
        }
        initializer {
            SignInViewModel(
                signInUserUseCase = SignInUseCase(
                    akinApplication().container.userRepository,
                    AuthRepository()
                ),
            )
        }
        initializer {
            SignUpViewModel(
                signUpUseCase = SignUpUseCase(
                    akinApplication().container.userRepository,
                    AuthRepository()
                ),
                signInUseCase = SignInUseCase(
                    akinApplication().container.userRepository,
                    AuthRepository()
                )
            )
        }

    }
}

fun CreationExtras.akinApplication(): AkinApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as AkinApplication)