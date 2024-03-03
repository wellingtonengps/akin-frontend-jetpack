package com.example.akin.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.akin.network.dto.JwtResponseDTO
import com.example.akin.network.repository.UserRepository
import com.example.akin.ui.firstPage.FirstPage
import com.example.akin.ui.firstPage.FirstPageDestination
import com.example.akin.ui.home.HomeDestination
import com.example.akin.ui.home.Main
import com.example.akin.ui.signIn.SignIn
import com.example.akin.ui.signIn.SignInDestination
import com.example.akin.ui.signUp.SignUp
import com.example.akin.ui.signUp.SignUpDestination
import kotlinx.coroutines.launch

@Composable
fun AkinNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    var responseTokens: JwtResponseDTO? = null
    val userRepository = UserRepository()

    NavHost(navController = navController, startDestination = HomeDestination.route) {
        composable(route = HomeDestination.route) { backStackEntry ->
            backStackEntry.arguments?.let { tokens ->
                Main(navController = navController, responseToken = tokens)
            } ?: LaunchedEffect(null) {
                navController.navigate(SignInDestination.route)
            }

        }
        composable(route = FirstPageDestination.route) {
            FirstPage(navController)
        }
        composable(route = SignInDestination.route) {
            SignIn(navController, onSignIn = {
                scope .launch {
                    responseTokens = userRepository.signIn(it)
                    navController.navigate(
                        "main/{${
                            responseTokens
                        }}"
                    )
                    Log.i("JwtResponse", "onCreate: $responseTokens")
                }
            })
        }
        composable(route = SignUpDestination.route) {
            SignUp()
        }
    }
}