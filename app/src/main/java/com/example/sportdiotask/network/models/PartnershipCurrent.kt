package com.example.sportdiotask.network.models

import java.io.Serializable

data class PartnershipCurrent(
    val Balls: String,
    val Batsmen: List<BatsmenX>,
    val Runs: String
): Serializable