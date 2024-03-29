package com.example.akin.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.akin.home.data.Event
import java.util.Date

@Composable
fun EventCardList(events: List<Event>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 26.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(events) {
            event-> EventCard(event = event)
        }
    }
}

@Preview(showBackground = true, device = Devices.DEFAULT)
@Composable
private fun EventCardListPreview() {
    EventCardList(events = events)
}

val participant1 = listOf("João", "Maria", "José")
val participant2 = listOf("Ana", "Pedro", "Mariana")
val participant3 = listOf("Carlos", "Juliana", "Rafael")

val events = listOf(
    Event(
        id = 1,
        title = "RPG da UFJF",
        date = Date(),
        description = "Jogar RPG de mesa na UFJF",
        location = "Jardim da UFJF",
        participantList = participant1,
        category = "video_games"
    ),
    Event(
        id = 2,
        title = "Corrida beneficente",
        date = Date(),
        description = "Corrida para arrecadar fundos",
        location = "Parque da cidade",
        participantList = participant2,
        category = "sports"
    ),
    Event(
        id = 3,
        title = "Feira de ciências",
        date = Date(),
        description = "Apresentação de experimentos científicos",
        location = "Escola Municipal",
        participantList = participant3,
        category = "education"
    )
)
