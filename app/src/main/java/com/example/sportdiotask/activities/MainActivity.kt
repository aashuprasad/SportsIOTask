package com.example.sportdiotask.activities

import android.os.Bundle
import android.view.View.GONE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.sportdiotask.adapter.MatchAdapter
import com.example.sportdiotask.databinding.ActivityMainBinding
import com.example.sportdiotask.network.MatchAPIService
import com.example.sportdiotask.network.models.ApiUtilities
import com.example.sportdiotask.network.models.SAPKMatch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var matchDataList: ArrayList<SAPKMatch> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val matchApi = ApiUtilities.getInstance().create(MatchAPIService::class.java)

        lifecycleScope.launch(Dispatchers.IO) {
            val result = matchApi.getPakSa()
            val result2 = matchApi.getIndNew()
            if (result.body() != null || result2.body() != null) {
                //Log.d("DATA", "onCreate: ${result.body()!!.matchdetail.Series}")
                matchDataList.add(result.body()!!)
                matchDataList.add(result2.body()!!)
                withContext(Dispatchers.Main) {
                    binding.progressbar.visibility = GONE
                    binding.recyclerView.adapter =
                        MatchAdapter(this@MainActivity, matchDataList)
                }
            }
        }
    }
}