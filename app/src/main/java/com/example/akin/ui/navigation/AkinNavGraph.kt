package com.example.akin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.akin.auth.domain.UserResponseDTO
import com.example.akin.auth.data.AuthRepository
import com.example.akin.ui.firstPage.FirstPage
import com.example.akin.ui.firstPage.FirstPageDestination
import com.example.akin.ui.home.HomeDestination
import com.example.akin.ui.home.Main
import com.example.akin.auth.presentation.signIn.SignIn
import com.example.akin.auth.presentation.signIn.SignInDestination
import com.example.akin.auth.presentation.signUp.SignUp
import com.example.akin.auth.presentation.signUp.SignUpDestination

@Composable
fun AkinNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    var responseTokens: UserResponseDTO
    val userRepository = AuthRepository()

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
            /*
            * onSignIn = {
                scope .launch {
                    responseTokens = userRepository.signIn(it)
                    navController.navigate(
                        "main/{${
                            responseTokens
                        }}"
                    )
                    Log.i("JwtResponse", "onCreate: $responseTokens")
                }
            }*/

            SignIn(navController)
        }
        composable(route = SignUpDestination.route) {
            SignUp()
        }
    }
}