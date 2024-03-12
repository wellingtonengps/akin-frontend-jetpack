package com.example.akin.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.akin.auth.domain.UserResponseDTO
import com.example.akin.navigation.NavigationDestination


object HomeDestination : NavigationDestination {
    override val route = "home"
    const val userInfo = ""
    val routWithArgs = "$route/{$userInfo}"
}

@Composable
fun Home(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "home")
       /*if (user != null) {
            Text(text = "name: ${user.name}")
            Text(text = "lastName: ${user.lastName}")
            Text(text = "username: ${user.username}")

        }*/
    }
}