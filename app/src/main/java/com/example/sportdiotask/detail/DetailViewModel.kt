package com.example.sportdiotask.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

import com.example.sportdiotask.R
import com.example.sportdiotask.network.models.Match


class DetailViewModel(match: Match, app: Application) : AndroidViewModel(app) {

    private val _matches = MutableLiveData<Match>()
    val matches:LiveData<Match> get() = _matches

    /*val displayPlayerName = Transformations.map(match) {
        app.applicationContext.getString(
            when (it.isRental) {
                true -> R.string.display_price_monthly_rental
                false -> R.string.display_price
            }, it.price)
    }*/

    init{
        _matches.value = match
    }

}
