package com.example.akin.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class JwtResponseDTO(
    private val accessToken: String,
    private val refreshToken: String
)