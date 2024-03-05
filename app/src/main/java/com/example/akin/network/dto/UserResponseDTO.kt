package com.example.akin.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserResponseDTO(
    val name: String,
    val lastName: String,
    val gender: String,
    val email: String,
    val avatar: String,
    val username: String,
    val accessToken: String,
    val refreshToken: String,
    val accountNonExpired: Boolean,
    val accountNonLocked: Boolean,
    val credentialsNonExpired: Boolean,
    val enabled: Boolean
)
