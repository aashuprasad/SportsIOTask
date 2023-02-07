package com.example.sportdiotask.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.sportdiotask.R

class MatchDetailAdapter(requireActivity: Context, data:ArrayList<String>?) :  RecyclerView.Adapter<MatchDetailAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        /*val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
*/
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.match_detail_item_layout, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
    return 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }


}
