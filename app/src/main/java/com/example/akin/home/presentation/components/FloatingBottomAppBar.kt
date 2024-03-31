package com.example.akin.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FloatingBottomAppBar(

) {
    BottomAppBar(
        modifier = Modifier
            .height(60.dp)
            .width(200.dp)
            .clip(shape = RoundedCornerShape(74.dp)),
    ){
        Row (
            modifier = Modifier.fillMaxWidth().padding(6.dp),
            Arrangement.SpaceBetween,
            Alignment.CenterVertically
        ){
            IconButton(
                onClick = { /* do something */ },
                Modifier.background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(73.dp))
            ) {
                Icon(Icons.Filled.Check, contentDescription = "Localized description")
            }
            IconButton(onClick = { /* do something */ },  Modifier.background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(73.dp))) {
                Icon(Icons.Filled.Check, contentDescription = "Localized description")
            }
            IconButton(onClick = { /* do something */ },  Modifier.background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(73.dp))) {
                Icon(Icons.Filled.Check, contentDescription = "Localized description")
            }
        }
    }
}


@Preview
@Composable
private fun FloatingBottomAppBarPreview() {
    FloatingBottomAppBar()
}