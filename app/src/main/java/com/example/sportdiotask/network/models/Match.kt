package com.example.sportdiotask.network.models

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("Innings") val innings: List<Inning>,
    @SerializedName("Matchdetail") val matchdetail: Matchdetail,
    @SerializedName("Notes") val notes: Notes,
    @SerializedName("Nuggets") val nuggets: List<String>,
    @SerializedName("Teams") val teams: Teams
):    java.io.Serializable
