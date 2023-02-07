package com.example.sportdiotask.network.models

import java.io.Serializable

data class Series(
    val Id: String,
    val Name: String,
    val Status: String,
    val Tour: String,
    val Tour_Name: String
): Serializable