package com.example.akin.ui.firstPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.akin.R
import com.example.akin.navigation.NavigationDestination

object FirstPageDestination : NavigationDestination {
    override val route = "firstPage"
}


@Composable
fun FirstPage(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_image),
            contentDescription = "logo",
        )

        Spacer(modifier = Modifier.height(131.dp))

        Button(
            onClick = { navController.navigate("signIn") },
            modifier = Modifier.size(287.dp, 54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF44E267),
                contentColor = Color(0xFF000000)
            )
        ) {
            Text(text = stringResource(R.string.entrar), fontSize = 16.sp)
        }


        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("signUp") },
            modifier = Modifier.size(287.dp, 54.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF860DFF),
                contentColor = Color(0xFFF5F5F5)
            )
        ) {
            Text(text = stringResource(R.string.criar_conta), fontSize = 16.sp)
        }

    }
}