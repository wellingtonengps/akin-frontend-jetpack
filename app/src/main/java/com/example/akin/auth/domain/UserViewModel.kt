package com.example.akin.auth.domain

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.akin.auth.data.User
import com.example.akin.auth.data.UserRepository
import com.example.akin.auth.data.toUserResponseDTO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel(
) {

    private val _userInfo = MutableStateFlow<UserResponseDTO?>(null)
    val userInfo: StateFlow<UserResponseDTO?> = _userInfo

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn


    init {
        getUserStream(1)
    }

    fun getUserStream(id: Long = 1) {
        viewModelScope.launch {
            userRepository.getUserStream(id).collect { user ->
                _userInfo.value = user?.toUserResponseDTO()
                _isLoggedIn.value = user != null
            }
        }
    }
}