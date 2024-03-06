package com.example.akin.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.akin.auth.data.User
import com.example.akin.auth.data.UserDao
import com.example.akin.auth.data.utils.Converters

@Database(entities = [User::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AkinDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var Instance: AkinDatabase? = null

        fun getDataBase(context: Context): AkinDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AkinDatabase::class.java, "user_database").fallbackToDestructiveMigration().build()
                    .also { Instance = it }
            }
        }
    }
}