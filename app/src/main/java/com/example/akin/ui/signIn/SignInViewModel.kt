package com.example.akin.ui.signIn

import androidx.lifecycle.ViewModel
import com.example.akin.data.User
import com.example.akin.data.UsersRepository
import com.example.akin.network.dto.UserRequestDTO
import com.example.akin.network.dto.UserResponseDTO
import com.example.akin.network.repository.UserRepository
import java.util.Date

class SignInViewModel(
    private val usersRepository: UsersRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    suspend fun saveItem() {
        val user = userRepository.signIn(UserRequestDTO("username4", "password4")).toUser()
        usersRepository.insertUser(user)
    }
}

fun UserResponseDTO.toUser(): User = User(
    name = name,
    lastName = lastName,
    gender = gender,
    email = email,
    avatar = avatar,
    username = username,
    accessToken = accessToken,
    refreshToken = refreshToken,
    accountNonExpired = accountNonExpired,
    credentialsNonExpired = credentialsNonExpired,
    accountNonLocked = accountNonLocked,
    enabled = enabled,
)
