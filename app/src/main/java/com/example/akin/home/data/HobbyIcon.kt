package com.example.akin.home.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.ui.graphics.vector.ImageVector

enum class HobbyIcon(val icon: ImageVector) {
    VIDEO_GAMES(Icons.Filled.SportsEsports),
    TENNIS(Icons.Filled.SportsTennis),
    SOCCER(Icons.Filled.SportsSoccer)
}