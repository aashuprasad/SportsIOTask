package com.example.sportdiotask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportdiotask.R
import com.example.sportdiotask.databinding.DetailItemLayoutBinding
import com.example.sportdiotask.databinding.ItemLayoutBinding
import com.example.sportdiotask.network.models.PlayerStats
import com.example.sportdiotask.network.models.Teams

class MatchDetailAdapter(val context: Context, val players: List<PlayerStats> ): RecyclerView.Adapter<MatchDetailAdapter.MatchDetailViewHolder>() {

    class MatchDetailViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding = DetailItemLayoutBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchDetailViewHolder {
        return MatchDetailViewHolder(
            LayoutInflater.from(context).inflate(R.layout.detail_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MatchDetailViewHolder, position: Int) {
        val playerData = players[position]
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
           /* holder.binding.apply {
                //playerName.text = playerData.NameFull
               // playerName.text = playerData.NameFull
            }*/


        }
    }

    override fun getItemCount(): Int {
        return players.size
    }


}