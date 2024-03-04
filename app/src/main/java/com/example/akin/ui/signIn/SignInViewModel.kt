package com.example.akin.ui.signIn

import androidx.lifecycle.ViewModel
import com.example.akin.data.User
import com.example.akin.data.UsersRepository
import com.example.akin.network.repository.UserRepository
import java.util.Date

class SignInViewModel(
    private val usersRepository: UsersRepository,
) : ViewModel() {

    suspend fun saveItem() {
        val user = User(
            name = "John",
            lastName = "Doe",
            gender = "Male",
            email = "johndoe@example.com",
            password = "password123",
            avatar = "avatar_url_here",
            birthDate = Date(),
            username = "johndoe"
        )

        usersRepository.insertUser(user)
    }

}

