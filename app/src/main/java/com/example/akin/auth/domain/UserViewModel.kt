package com.example.akin.auth.domain

import android.util.Log
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

    init {
        getUserStream(1)
    }

    //todo: precisa verificar se exite usuário no
    // banco de dados, depois verificar se ele possui token válido
    private fun getUserStream(id: Long) {
        viewModelScope.launch {
            userRepository.getUserStream(id).collect { user ->
                _userInfo.value = user?.toUserResponseDTO()
            }
        }
    }

}