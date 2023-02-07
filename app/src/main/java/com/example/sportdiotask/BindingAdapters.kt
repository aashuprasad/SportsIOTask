package com.example.sportdiotask

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sportdiotask.match.MatchAdapter
import com.example.sportdiotask.match.MatchApiStatus
import com.example.sportdiotask.network.models.Match


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Match>?){
    val adapter = recyclerView.adapter as MatchAdapter
    adapter.submitList(data)
}

@BindingAdapter("marsApiStatus")
fun bindStatus (statusImageView: ImageView, status: MatchApiStatus?){
    when (status){
        MatchApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MatchApiStatus.ERROR ->{
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MatchApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}
