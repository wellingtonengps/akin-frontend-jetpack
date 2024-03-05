package com.example.akin.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserRequestDTO(
    val username: String,
    val password: String
)
