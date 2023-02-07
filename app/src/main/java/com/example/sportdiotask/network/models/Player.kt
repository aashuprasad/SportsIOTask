package com.example.sportdiotask.network.models

import java.io.Serializable

data class Player(
    val Name_Full: String,
    val Name_Short: String,
    val Players: Map<String, PlayerStats>
): Serializable