package com.example.akin.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class JwtResponseDTO(
    val accessToken: String,
    val refreshToken: String
){

}