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

class MatchDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityMatchDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sapkMatch = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.extras?.getSerializable("matchDetail", SAPKMatch::class.java)
        } else {
            intent.extras?.getSerializable("matchDetail")
        } as SAPKMatch
        Log.d(this.javaClass.simpleName, Gson().toJson(sapkMatch))

        var saplayerStats: PlayerStats? = null
        for (map in sapkMatch.teams.entries) {
            for (playerStat in map.value.Players.entries) {
                saplayerStats = playerStat.value
            }
        }
        binding.team1RV.adapter = MatchDetailAdapter(this, listOf(saplayerStats!!))
        binding.team2RV.adapter = MatchDetailAdapter(this, listOf(saplayerStats!!))
    }
}





/*class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    var pakPlayerDetailList: MutableList<PlayerDetail> = mutableListOf()
    var saPlayerDetailList: MutableList<PlayerDetail> = mutableListOf()
    var indPlayerDetailList: MutableList<PlayerDetail> = mutableListOf()
    var nzPlayerDetailList: MutableList<PlayerDetail> = mutableListOf()

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val teamsData = intent.extras?.getSerializable("name") as Teams



        var pakPlayerData: Map<String, PlayerDetail>? = null
        var saPlayerData: Map<String, PlayerDetail>? = null
        var indPlayerData: Map<String, PlayerDetail>? = null
        var nzPlayerData: Map<String, PlayerDetail>? = null

        pakPlayerDetailList.clear()
        saPlayerDetailList.clear()
        indPlayerDetailList.clear()
        nzPlayerDetailList.clear()

        if (intent.getStringExtra("match1").equals("savspak")) {
            pakPlayerData = teamsData.pak?.Players
            saPlayerData = teamsData.south_africa?.Player
            pakPlayerData?.forEach {
                pakPlayerDetailList.add(it.value)
            }
            saPlayerData?.forEach {
                saPlayerDetailList.add(it.value)
            }

            binding.tvTeam1.text = teamsData.pak?.NameFull
            binding.tvTeam2.text = teamsData.south_africa?.NameFull
            binding.rcvTeamOne.apply {
                this.layoutManager =
                    LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
                this.adapter = MatchDetailAdapter(this@DetailActivity, pakPlayerDetailList)
            }

            binding.rcvTeamTwo.apply {
                this.layoutManager =
                    LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
                this.adapter = MatchDetailAdapter(this@DetailActivity, saPlayerDetailList)
            }
        } else if (intent.getStringExtra("match2").equals("indvsnz")) {
            indPlayerData = teamsData.ind?.Players
            nzPlayerData = teamsData.nz?.Players
            indPlayerData?.forEach {
                indPlayerDetailList.add(it.value)
            }
            nzPlayerData?.forEach {
                nzPlayerDetailList.add(it.value)
            }
            binding.tvTeam1.text = teamsData.ind?.NameFull
            binding.tvTeam2.text = teamsData.nz?.NameFull
            binding.rcvTeamOne.apply {
                this.layoutManager =
                    LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
                this.adapter = MatchDetailAdapter(this@DetailActivity, indPlayerDetailList)
            }

            binding.rcvTeamTwo.apply {
                this.layoutManager =
                    LinearLayoutManager(this@DetailActivity, LinearLayoutManager.VERTICAL, false)
                this.adapter = MatchDetailAdapter(this@DetailActivity, nzPlayerDetailList)
            }
        }

    }
}*/