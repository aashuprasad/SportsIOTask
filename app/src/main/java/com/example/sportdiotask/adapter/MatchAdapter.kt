import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportdiotask.R
import com.example.sportdiotask.databinding.ItemLayoutBinding
import com.example.sportdiotask.network.models.Match
import com.example.sportdiotask.network.models.Matchdetail

/*
package com.example.sportdiotask.adapter

import android.content.Context

class MatchAdapter(val context : Context, val list: List) {
}*/

class MatchAdapter(val context: Context, val data: List<Match>) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>(){

    class MatchViewHolder(view: View): RecyclerView.ViewHolder(view){
        var binding = ItemLayoutBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val item = data

        holder.binding.matchTitle.text = item.toString()

    }

    override fun getItemCount(): Int {
        return data.size
    }
}