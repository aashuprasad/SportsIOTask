package com.example.sportdiotask.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportdiotask.R
import com.example.sportdiotask.activities.MatchDetailActivity
import com.example.sportdiotask.databinding.ItemLayoutBinding
import com.example.sportdiotask.network.models.Player
import com.example.sportdiotask.network.models.SAPKMatch

class MatchAdapter(val context: Context, val list: List<SAPKMatch>) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    class MatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemLayoutBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val item = list[position]

        holder.binding.apply {
            matchTitle.text = item.matchdetail.Series.Tour_Name
            matchStatus.text = item.matchdetail.Result
            matchType.text = item.matchdetail.Match.Type
            date.text = item.matchdetail.Match.Date
            venue.text = item.matchdetail.Venue.Name
        }



        var teamName1 = ""
        var teamName2 = ""
        var saPlayer: Player? = null
        var pakPlayer: Player? = null
        var inPlayer: Player? = null
        var nzPlayer: Player? = null

        for (i in item.teams.entries) {
            //Log.d(this.javaClass.simpleName, "Team.entries : ${i.value}")
            when (i.value.Name_Full) {
                "Pakistan" -> {
                    pakPlayer = i.value
                }
                "South Africa" -> {
                    saPlayer = i.value
                }
                "India" -> {
                    inPlayer = i.value
                }
                "New Zealand" -> {
                    nzPlayer = i.value
                }
            }
        }
        teamName1 = pakPlayer?.Name_Full + " v/s " + saPlayer?.Name_Full
        teamName2 = inPlayer?.Name_Full + " v/s " + nzPlayer?.Name_Full
        when {
            saPlayer != null && pakPlayer != null -> {
                holder.binding.teams.text = teamName1
            }
            inPlayer != null && nzPlayer != null -> {
                holder.binding.teams.text = teamName2
            }
        }

        holder.binding.matchItemView.setOnClickListener {
            val intent = Intent(context, MatchDetailActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("matchDetail", item)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

/*class MatchDetailAdapter(val context: Context, val playerDetailData: MutableList<PlayerDetail>) :
    RecyclerView.Adapter<MatchDetailAdapter.MatchDetailHolder>() {


    class MatchDetailHolder(val binding: MatchDetailItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchDetailHolder {
        return MatchDetailHolder(
            MatchDetailItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MatchDetailHolder, position: Int) {
        val playerData = playerDetailData[position]
        holder.apply {
            if (playerData.isKeeper == true && playerData.isCaptain == true) {
                binding.playerName.text = playerData.NameFull + "(" + "C/WK" + ")"
            } else if (playerData.isCaptain == true) {
                binding.playerName.text = playerData.NameFull + "(" + "C" + ")"
            } else if (playerData.isKeeper == true) {
                binding.playerName.text = playerData.NameFull + "(" + "WK" + ")"
            } else {

                binding.playerName.text = playerData.NameFull

            }
            binding.playerName.setOnClickListener {

                val builder = AlertDialog.Builder(context, com.google.android.material.R.style.Base_ThemeOverlay_AppCompat_Dialog_Alert).create()
                val view = LayoutInflater.from(context).inflate(R.layout.custom_alert_dialog, null)
                builder.setView(view)
                val tvStrikeRate = view.findViewById<TextView>(R.id.tvStrikeRate)
                val tvStyle = view.findViewById<TextView>(R.id.tvStyle)
                val tvRuns = view.findViewById<TextView>(R.id.tvRuns)
                val tvAverage = view.findViewById<TextView>(R.id.tvAverage)


                tvStrikeRate.text = ("Strike rate is : ")+ playerData.batting?.strikeRate
                tvStyle.text = "Batting Style is :"+playerData.batting?.style
                tvRuns.text = "Run :"+playerData.batting?.runs
                tvAverage.text = "The average is : " + playerData.batting?.average

                builder.setCanceledOnTouchOutside(true)
                builder.show()
            }



        }


    }

    override fun getItemCount() = playerDetailData.size
}*/