package com.example.sportdiotask.network.models

import com.google.gson.annotations.SerializedName

data class Inning(
    @SerializedName("0")
    var inningFirst: InningDetail,

    @SerializedName("1")
    var inningSecond: InningDetail
)

data class InningDetail(
    val AllottedOvers: String,
    val Batsmen: List<Batsmen>,
    val Battingteam: String,
    val Bowlers: List<Bowler>,
    val Byes: String,
    val FallofWickets: List<FallofWicket>,
    val Legbyes: String,
    val Noballs: String,
    val Number: String,
    val Overs: String,
    val Partnership_Current: PartnershipCurrent,
    val Penalty: String,
    val PowerPlay: PowerPlay,
    val Runrate: String,
    val Target: String,
    val Total: String,
    val Wickets: String,
    val Wides: String
)