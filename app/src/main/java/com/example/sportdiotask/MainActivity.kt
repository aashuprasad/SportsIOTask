package com.example.sportdiotask

import MatchAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import androidx.lifecycle.lifecycleScope
import com.example.sportdiotask.databinding.ActivityMainBinding
import com.example.sportdiotask.network.MatchAPIService
import com.example.sportdiotask.network.models.ApiUtilities
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


/*
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val matchApi = ApiUtilities.getInstance().create(MatchAPIService::class.java)

        lifecycleScope.launch(Dispatchers.IO){
            val result = matchApi.getPakSa()

            if(result.body() != null){
                Log.d("DATA", "onCreate: ${result.body()!!.matchdetail.Player_Match}")

                withContext(Dispatchers.Main){
                    binding.progressbar.visibility = GONE
                    binding.recyclerView.adapter =
                        MatchAdapter(this@MainActivity, result.body()!!.matchdetail.Player_Match)

                }
            }

        }
    }
}*/
