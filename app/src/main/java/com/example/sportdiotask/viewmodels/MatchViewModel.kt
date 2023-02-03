/*
package com.example.sportdiotask.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sportdiotask.network.models.SAPKMatch

enum class MatchApiStatus{LOADING, ERROR, DONE}
class MatchViewModel: ViewModel(){
    */
/*
    * Screen 1:
It contains match details including team names.
1. Team Names (e.g. INDIA vs NEW ZEALAND).
2. Match Date-Time details & Venue details.
3. Navigation button to redirect on team & players information.*//*


    private val _status = MutableLiveData<MatchApiStatus>()
    val status: LiveData<MatchApiStatus> get() = _status

    private val _matches = MutableLiveData<List<SAPKMatch>>()
    val matches:LiveData<List<SAPKMatch>> get() = _matches

    private val _navigateToSelectedMatch = MutableLiveData<SAPKMatch>()
    val navigateToSelectedMatch:LiveData<SAPKMatch> get() = _navigateToSelectedMatch

    init {
        getMatchDetails(filter: MatchAPIFilter){
            viewModelScope.lau
        }
    }



}*/
