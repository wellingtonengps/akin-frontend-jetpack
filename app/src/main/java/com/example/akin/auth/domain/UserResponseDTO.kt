package com.example.akin.auth.domain

import com.example.akin.auth.data.User
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

fun UserResponseDTO.toUser(): User = User(
    name = name,
    lastName = lastName,
    gender = gender,
    email = email,
    avatar = avatar,
    username = username,
    accessToken = accessToken,
    refreshToken = refreshToken,
    accountNonExpired = accountNonExpired,
    credentialsNonExpired = credentialsNonExpired,
    accountNonLocked = accountNonLocked,
    enabled = enabled,
)
