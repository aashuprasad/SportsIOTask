package com.example.sportdiotask.network.models

import com.google.gson.annotations.SerializedName

data class Players(
    @SerializedName("Players") val player:List< Map<String, PlayerStats>>
    ) :
    java.io.Serializable

/*
data class Batting(

    @SerializedName("Style") var style: String? = null,
    @SerializedName("Average") var average: String? = null,
    @SerializedName("Strikerate") var strikeRate: String? = null,
    @SerializedName("Runs") var runs: String? = null

) : java.io.Serializable

data class Bowling(

    @SerializedName("Style") var style: String? = null,
    @SerializedName("Average") var average: String? = null,
    @SerializedName("Economyrate") var economyRate: String? = null,
    @SerializedName("Wickets") var wickets: String? = null

) : java.io.Serializable*/
