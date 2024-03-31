package com.example.akin.home.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.akin.R
import com.example.akin.auth.data.UserRepository
import com.example.akin.auth.domain.UserResponseDTO
import com.example.akin.auth.domain.UserViewModel
import com.example.akin.auth.presentation.signIn.SignInViewModel
import com.example.akin.home.data.Event
import com.example.akin.home.data.Hobby
import com.example.akin.home.data.events
import com.example.akin.home.presentation.components.EventCardList
import com.example.akin.home.presentation.components.FloatingBottomAppBar
import com.example.akin.home.presentation.components.Hobbies
import com.example.akin.home.presentation.components.SuggestionCardList
import com.example.akin.navigation.NavigationDestination
import com.example.akin.ui.AppViewModelProvider
import java.util.Date


object HomeDestination : NavigationDestination {
    override val route = "home"
    const val userInfo = ""
    val routWithArgs = "$route/{$userInfo}"
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(
    navController: NavHostController,
    userViewModel: UserViewModel = viewModel(factory = AppViewModelProvider.Factory),
) {

    val user by userViewModel.userInfo.collectAsState()
    val hobbiesList = listOf(
        Hobby(id = 1, name = "video_games"),
        Hobby(id = 2, name = "tennis"),
        Hobby(id = 3, name = "soccer")
    )


    Scaffold(
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                FloatingBottomAppBar()
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {


            Row(
                modifier = Modifier
                    .padding(top = 34.dp, start = 26.dp, bottom = 26.dp)
                    .height(100.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "profile image",
                    Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.width(15.dp))

                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxHeight()
                ) {
                    user?.let {
                        Text(text = "${it.name} ${it.lastName}", fontSize = 20.sp)
                        Text(text = "@${it.username}", fontSize = 18.sp)
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    Hobbies(hobbiesList)
                }


            }

            Column(
            ) {
                Text(
                    text = "Seus eventos",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 16.dp, start = 26.dp)
                )

                EventCardList(events = events)

                Text(
                    text = "Sugestões",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 26.dp, top = 26.dp)
                )

                SuggestionCardList(events = events)
            }


        }
    }
}