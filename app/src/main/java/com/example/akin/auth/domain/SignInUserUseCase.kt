package com.example.akin.auth.domain

import com.example.akin.auth.data.AuthRepository
import com.example.akin.auth.data.UserRepository

class SignInUserUseCase(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(username: String, password: String): UserResponseDTO {
        val user: UserResponseDTO = authRepository.signIn(
            UserRequestDTO(
                username, password
            )
        )
        userRepository.insertUser(user.toUser())

        return user;
    }
}