package com.example.akin.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.akin.R
import com.example.akin.navigation.NavigationDestination

object SplashDestination : NavigationDestination {
    override val route = "splash"
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.green_100), colorResource(
                            id = R.color.purple_100
                        )
                    )
                )
            ),
        Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_splash),
            contentDescription = "logo",
        )
    }
}