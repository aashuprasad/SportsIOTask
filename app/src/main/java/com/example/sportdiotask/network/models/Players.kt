package com.example.sportdiotask.network.models

import com.google.gson.annotations.SerializedName

data class Players(
    @SerializedName("Players") val player:List< Map<String, PlayerStats>>
    ) :
    java.io.Serializable
