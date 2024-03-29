package com.example.akin.auth.domain

import com.example.akin.auth.data.AuthRepository
import com.example.akin.auth.data.UserRepository

class SignUpUseCase(
    private val userRepository: UserRepository,
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(user: SignUpRequestDTO): UserResponseDTO {
        val user: UserResponseDTO = authRepository.signUp(user)
        userRepository.insertUser(user.toUser())



        return user;
    }
}