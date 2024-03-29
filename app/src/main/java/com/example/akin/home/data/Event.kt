package com.example.akin.home.data

import java.util.Date

class Event(
    val id: Long,
    val title: String,
    val date: Date,
    val description: String,
    val location: String,
    val participantList: List<String>,
    val category: String,
) {
}