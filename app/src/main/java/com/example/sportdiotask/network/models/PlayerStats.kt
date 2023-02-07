package com.example.sportdiotask.network.models

import com.google.gson.annotations.SerializedName

data class PlayerStats(

    @SerializedName("Position") var Position: String? = null,
    @SerializedName("Name_Full") var NameFull: String? = null,
    @SerializedName("Batting") var Batting  : Batting? = null,
    @SerializedName("Bowling") var Bowling  : Bowling? = null,
    @SerializedName("Iskeeper") var isKeeper: Boolean? = null,
    @SerializedName("Iscaptain") var isCaptain: Boolean? = null

    ) : java.io.Serializable