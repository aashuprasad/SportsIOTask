package com.example.sportdiotask.network.models

data class PlayerData(
    val Name_Full: String,
    val Name_Short: String,
    val Players: Map<String, PlayerStats>
)