package com.example.akin.auth.domain

import com.example.akin.auth.data.AuthRepository
import com.example.akin.auth.data.UserRepository

class SignInUseCase(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(credentials: SignInRequestDTO): UserResponseDTO {
        val user: UserResponseDTO = authRepository.signIn(credentials)
        userRepository.insertUser(user.toUser())

        return user;
    }
}