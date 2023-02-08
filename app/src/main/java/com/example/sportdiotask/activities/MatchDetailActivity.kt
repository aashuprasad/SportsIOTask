package com.example.sportdiotask.activities

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sportdiotask.adapter.MatchDetailAdapter
import com.example.sportdiotask.databinding.ActivityMatchDetailBinding
import com.example.sportdiotask.network.models.PlayerStats
import com.example.sportdiotask.network.models.SAPKMatch
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_layout.*

class MatchDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityMatchDetailBinding
    var inList: MutableList<String> = mutableListOf()
    var nzList: MutableList<String> = mutableListOf()
    var pkList: MutableList<String> = mutableListOf()
    var saList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sapkMatch = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.extras?.getSerializable("matchDetail", SAPKMatch::class.java)
        } else {
            intent.extras?.getSerializable("matchDetail")
        } as SAPKMatch

/*
        Log.d(this.javaClass.simpleName, Gson().toJson(sapkMatch.teams.entries))
*/

        for (i in sapkMatch.teams.entries) {
            if (i.value.Name_Full == "India") {
                for (j in i.value.Players.entries) {
                    Log.d(this.javaClass.simpleName, "Team.entries : ${j.value.NameFull}")
                    inList.add(j.value.NameFull.toString())
                }
            }
            if (i.value.Name_Full == "New Zealand") {
                for (j in i.value.Players.entries) {
                    Log.d(this.javaClass.simpleName, "Team.entries : ${j.value.NameFull}")
                    nzList.add(j.value.NameFull.toString())
                }
            }
            if (i.value.Name_Full == "Pakistan") {
                for (j in i.value.Players.entries) {
                    Log.d(this.javaClass.simpleName, "Team.entries : ${j.value.NameFull}")
                    pkList.add(j.value.NameFull.toString())
                }
            }
            if (i.value.Name_Full == "South Africa") {
                for (j in i.value.Players.entries) {
                    Log.d(this.javaClass.simpleName, "Team.entries : ${j.value.NameFull}")
                    saList.add(j.value.NameFull.toString())
                }
            }
        }

        if (sapkMatch.matchdetail.Venue.Id != "84") {
            binding.team1RV.adapter = MatchDetailAdapter(this,inList)
            binding.team2RV.adapter = MatchDetailAdapter(this, nzList)

        }else {
            binding.team1RV.adapter = MatchDetailAdapter(this, pkList)
            binding.team2RV.adapter = MatchDetailAdapter(this, saList)
        }
    }
}

