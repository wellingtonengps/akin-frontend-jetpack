package com.example.akin.auth.domain

import androidx.lifecycle.ViewModel
import com.example.akin.auth.data.User
import com.example.akin.auth.data.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow

class UserViewModel(private val userRepository: UserRepository): ViewModel(
) {

    private val _userInfo = MutableStateFlow<User?>(null)
    val userInfo: StateFlow<User?> = _userInfo

}