package com.example.akin.auth.domain

import kotlinx.serialization.Serializable

@Serializable
data class JwtResponseDTO(
    val accessToken: String,
    val refreshToken: String
)