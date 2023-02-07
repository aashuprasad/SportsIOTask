package com.example.sportdiotask.match

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sportdiotask.databinding.MatchItemLayoutBinding
import com.example.sportdiotask.network.models.Match

class MatchAdapter(val onClickListener: OnClickListener): androidx.recyclerview.widget.ListAdapter<Match, MatchAdapter.MatchViewHolder>(DiffCallback){



    class MatchViewHolder(private var binding: MatchItemLayoutBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(match: Match){
            binding.match = match
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Match>(){
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem===newItem
        }

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
            return oldItem.matchdetail==newItem.matchdetail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int):
            MatchViewHolder{
        return MatchViewHolder(MatchItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int){
        val match = getItem(position)
        holder.bind(match)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(match)
        }
    }

    class OnClickListener(val clickListener: (match: Match)->Unit){
        fun onClick(match: Match) = clickListener(match)
    }

}

