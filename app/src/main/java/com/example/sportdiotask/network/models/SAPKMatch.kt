package com.example.sportdiotask.network.models

import com.google.gson.annotations.SerializedName

data class SAPKMatch(
    @SerializedName("Innings") val innings: List<Inning>,
    val Matchdetail: Matchdetail,
    val Notes: Notes,
    val Nuggets: List<String>,
    val Teams: Teams
)