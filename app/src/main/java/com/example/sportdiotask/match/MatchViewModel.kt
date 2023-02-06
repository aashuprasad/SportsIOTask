package com.example.sportdiotask.match

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sportdiotask.network.MatchAPI
import com.example.sportdiotask.network.models.Match
import kotlinx.coroutines.launch

enum class MatchApiStatus{LOADING, ERROR, DONE}

class MatchViewModel: ViewModel(){

    private val _status = MutableLiveData<MatchApiStatus>()
    val status: LiveData<MatchApiStatus> get() = _status

    private val _matches = MutableLiveData<List<Match>>()
    val matches:LiveData<List<Match>> get() = _matches

    private val _navigateToSelectedMatch = MutableLiveData<Match>()
    val navigateToSelectedMatch:LiveData<Match> get() = _navigateToSelectedMatch



    init {
        getMatch()
    }

    private fun getMatch(){
        viewModelScope.launch{
            _status.value = MatchApiStatus.LOADING
            try {
                _status.value = MatchApiStatus.DONE
                _matches.value = listOf(MatchAPI.retrofitService.getPakSa().body()!!)
            }catch (e:Exception){
                _status.value = MatchApiStatus.ERROR
                _matches.value = null}
        }
    }


    fun displayMatchDetails(match: Match){
        _navigateToSelectedMatch.value = match
    }

    fun displayMatchDetailsComplete() {
        _navigateToSelectedMatch.value = null
    }



}
