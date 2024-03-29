package com.example.akin.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.akin.auth.domain.UserResponseDTO
import com.example.akin.auth.domain.UserViewModel
import com.example.akin.ui.firstPage.FirstPage
import com.example.akin.ui.firstPage.FirstPageDestination
import com.example.akin.home.presentation.HomeDestination
import com.example.akin.auth.presentation.signIn.SignIn
import com.example.akin.auth.presentation.signIn.SignInDestination
import com.example.akin.auth.presentation.signIn.SignInViewModel
import com.example.akin.auth.presentation.signUp.SignUp
import com.example.akin.auth.presentation.signUp.SignUpDestination
import com.example.akin.ui.AppViewModelProvider
import com.example.akin.home.presentation.Home

@Composable
fun AkinNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    signViewModel: SignInViewModel = viewModel(factory = AppViewModelProvider.Factory),
    userViewModel: UserViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {

    LaunchedEffect(key1 = userViewModel.isLoggedIn) {
        userViewModel.getUserStream(1)
    }

    val isLoggedIn by userViewModel.isLoggedIn.collectAsState()

    val startRoute = if(isLoggedIn) "home_graph" else
        "auth_graph"

    NavHost(navController = navController, startDestination = startRoute){


        auth(navController)
        home(navController)

        /*
        if (isLoggedIn) {
            navController.navigate("home_graph")
        } else {
            navController.navigate("auth_graph")
        }*/
    }
}

fun NavGraphBuilder.auth(navController: NavHostController){
    navigation(startDestination = SignInDestination.route, route = "auth_graph") {
        composable(route = SignInDestination.route) {
            SignIn(navController)
        }

        composable(route = SignUpDestination.route){
            SignUp()
        }
    }
}

fun NavGraphBuilder.home(navController: NavHostController){
    navigation(startDestination = HomeDestination.route, route = "home_graph") {
        composable(HomeDestination.route) {
          Home(navController = navController)
        }
        /*
        composable(Destinations.SCREEN_ONE.name) {
            ScreenOne {
                navController.navigateUp()
            }
        }
        composable(Destinations.SCREEN_TWO.name) {
            ScreenTwo {
                navController.navigateUp()
            }
        }*/
    }
}

fun NavController.navigateToSingleTop(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
