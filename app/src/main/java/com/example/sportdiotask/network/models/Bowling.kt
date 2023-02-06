package com.example.sportdiotask.network.models

import com.google.gson.annotations.SerializedName

data class Bowling(

    @SerializedName("Style") var style: String? = null,
    @SerializedName("Average") var average: String? = null,
    @SerializedName("Economyrate") var economyRate: String? = null,
    @SerializedName("Wickets") var wickets: String? = null

) : java.io.Serializable