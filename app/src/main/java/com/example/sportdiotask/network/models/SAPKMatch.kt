package com.example.sportdiotask.network.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SAPKMatch(
    @SerializedName("Innings") val innings: List<Inning>,
    @SerializedName("Matchdetail") val matchdetail: Matchdetail,
    val Notes: Notes,
    val Nuggets: List<String>,
    @SerializedName("Teams")
    val teams: Map<String, Player>
) : Serializable