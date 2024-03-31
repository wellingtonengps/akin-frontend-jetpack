package com.example.akin.home.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.akin.home.data.Event
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun SuggestionCard(
    event: Event
) {

    val calendar = Calendar.getInstance()
    calendar.time = event.date
    val dayEvent = calendar.get(Calendar.DAY_OF_MONTH)

    val dateFormat = SimpleDateFormat("MMMM", Locale("pt", "BR"))
    val monthEvent = dateFormat.format(event.date)

    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFD9D9D9)
        ),
        border = BorderStroke(2.dp, Color(0xFF1E1E1E)),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp)
        ) {
            Column {
                Text(text = event.title, fontSize = 20.sp, modifier = Modifier.padding(bottom = 2.dp))
                Text(text = "Data: ${dayEvent} de ${monthEvent}", fontSize = 18.sp, modifier = Modifier.padding(bottom = 2.dp))
                Text(text = "Local: ${event.location}", modifier = Modifier.padding(bottom = 8.dp))
                /*
                Icon(
                    imageVector = HobbyIcon.valueOf(event.category.uppercase()).icon,
                    contentDescription = "category event"
                )*/
                Hobbies(hobbies = hobbiesList)
            }
        }
    }
}

@Preview
@Composable
private fun SuggestionCardPreview() {
    SuggestionCard(event = event)
}


