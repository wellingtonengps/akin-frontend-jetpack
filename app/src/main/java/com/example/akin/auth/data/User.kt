package com.example.akin.auth.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.akin.auth.domain.UserResponseDTO
import java.util.Date

@Entity(tableName = "user_account")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val lastName: String,
    val gender: String,
    val email: String,
    //val password: String,
    val avatar: String,
    //@TypeConverters()
    //val birthDate: Date,
    val username: String,
    val accessToken: String,
    val refreshToken: String,
    val enabled: Boolean = true,
    val accountNonLocked: Boolean = true,
    val accountNonExpired: Boolean = true,
    val credentialsNonExpired: Boolean = true,
    //val role: UserRole = UserRole.ADMIN,
) {

}

fun User.toUserResponseDTO(): UserResponseDTO {
    return UserResponseDTO(
        name = this.name,
        lastName = this.lastName,
        gender = this.gender,
        email = this.email,
        avatar = this.avatar,
        username = this.username,
        accessToken = this.accessToken,
        refreshToken = this.refreshToken,
        accountNonExpired = this.accountNonExpired,
        accountNonLocked = this.accountNonLocked,
        credentialsNonExpired = this.credentialsNonExpired,
        enabled = this.enabled
    )
}


