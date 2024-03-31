package com.example.akin.home.data

import java.util.Date

val participant = listOf("Well", "Emanuel", "Kamuel")

val event = Event(
    id = 1,
    title = "RPG da UFJF",
    date = Date(),
    description = "Jogar RPG de mesa na UFJF",
    location = "Jardim da UFJF",
    participantList = participant,
    category = "video_games"
)
