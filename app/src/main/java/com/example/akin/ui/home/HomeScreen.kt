package com.example.akin.ui.home

import android.os.Bundle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.akin.ui.navigation.NavigationDestination


object HomeDestination : NavigationDestination {
    override val route = "home"
    const val userInfo = ""
    val routWithArgs = "$route/{$userInfo}"
}

@Composable
fun Main(navController: NavHostController, responseToken: Bundle) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "accessToken: ${responseToken.getString("accessToken")}")
        Text(text = "refreshToken: ${responseToken.getString("refreshToken")}")
    }
}