package com.example.akin.auth.data

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getAllUsersStream(): Flow<List<User>>

    fun getUserStream(id: Long): Flow<User?>

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)

    suspend fun updateUser(user: User)
}