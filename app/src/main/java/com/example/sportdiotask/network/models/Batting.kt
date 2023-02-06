package com.example.sportdiotask.network.models

import com.google.gson.annotations.SerializedName

data class Batting(

    @SerializedName("Style") var style: String? = null,
    @SerializedName("Average") var average: String? = null,
    @SerializedName("Strikerate") var strikeRate: String? = null,
    @SerializedName("Runs") var runs: String? = null

) : java.io.Serializable