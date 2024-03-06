package com.example.akin.auth.domain

import kotlinx.serialization.Serializable

@Serializable
data class UserRequestDTO(
    val username: String,
    val password: String
)
