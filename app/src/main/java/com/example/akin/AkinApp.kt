package com.example.akin

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.akin.navigation.AkinNavHost

@Composable
fun AkinApp(navController: NavHostController = rememberNavController()) {
    AkinNavHost(navController = navController)
}