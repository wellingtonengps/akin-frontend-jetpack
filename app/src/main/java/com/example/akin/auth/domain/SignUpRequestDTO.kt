package com.example.akin.auth.domain

import kotlinx.serialization.Serializable


@Serializable
data class SignUpRequestDTO(
    val name: String,
    val lastName: String,
    val gender: String,
    val email: String,
    val password: String,
    val avatar: String,
    val username: String,
    val role: String = "USER"
) {
}