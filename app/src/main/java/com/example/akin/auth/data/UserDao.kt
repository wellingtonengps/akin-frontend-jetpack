package com.example.akin.auth.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

    @Update
    suspend fun update(user: User)

    @Delete
    suspend fun  delete(user: User)

    @Query("SELECT * from user_account WHERE id = :id")
    fun getUser(id: Long): Flow<User>

    @Query("SELECT * from user_account ORDER BY name ASC")
    fun getAllUsers(): Flow<List<User>>

}

