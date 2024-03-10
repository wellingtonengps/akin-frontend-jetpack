package com.example.akin.auth.domain

import kotlinx.serialization.Serializable

@Serializable
data class SignInRequestDTO(
    val username: String,
    val password: String
)
