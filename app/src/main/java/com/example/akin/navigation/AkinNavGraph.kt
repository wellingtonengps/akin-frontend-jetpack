package com.example.akin.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.akin.auth.domain.UserResponseDTO
import com.example.akin.auth.data.AuthRepository
import com.example.akin.ui.firstPage.FirstPage
import com.example.akin.ui.firstPage.FirstPageDestination
import com.example.akin.ui.home.HomeDestination
import com.example.akin.auth.presentation.signIn.SignIn
import com.example.akin.auth.presentation.signIn.SignInDestination
import com.example.akin.auth.presentation.signIn.SignInViewModel
import com.example.akin.auth.presentation.signUp.SignUp
import com.example.akin.auth.presentation.signUp.SignUpDestination
import com.example.akin.ui.AppViewModelProvider
import com.example.akin.ui.home.Home

@Composable
fun AkinNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: SignInViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {

    NavHost(navController = navController, startDestination = "auth") {
        composable(route = FirstPageDestination.route) {
            FirstPage(navController)
        }
        navigation(
            startDestination = SignInDestination.route,
            route = "auth"
        ) {
            composable(route = SignInDestination.route) {
                SignIn(navController)
            }
            composable(route = SignUpDestination.route) {
                SignUp()
            }
        }
        composable(route = HomeDestination.route) {
            Home(navController)
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}