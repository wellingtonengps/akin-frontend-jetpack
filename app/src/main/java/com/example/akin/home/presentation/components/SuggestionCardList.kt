package com.example.akin.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.akin.home.data.Event
import com.example.akin.home.data.events
import io.ktor.events.Events
import java.util.Date

@Composable
fun SuggestionCardList(events: List<Event>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 26.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(events) {
            event -> SuggestionCard(event = event)
        }
    }
}

@Preview
@Composable
private fun SuggestionCardListPreview() {
    SuggestionCardList(events = events)
}

