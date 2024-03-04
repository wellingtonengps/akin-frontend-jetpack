package com.example.akin.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import java.util.Date

@Entity(tableName = "user_account")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val lastName: String,
    val gender: String,
    val email: String,
    val password: String,
    val avatar: String,
    @TypeConverters()
    val birthDate: Date,
    val username: String,
    val enabled: Boolean = true,
    val accountNonLocked: Boolean = true,
    val accountNonExpired: Boolean = true,
    val credentialsNonExpired: Boolean = true,
    val role: UserRole = UserRole.ADMIN,
) {

}

