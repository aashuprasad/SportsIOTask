package com.example.sportdiotask.network

import com.example.sportdiotask.network.models.Match
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://demo.sportz.io/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface MatchAPIService {
    @GET("sapk01222019186652.json")
    suspend fun getPakSa(): Response<Match>

    @GET("nzin01312019187360.json")
    suspend fun getIndNew(): Response<Match>
}

object MatchAPI{
    val retrofitService: MatchAPIService by lazy { retrofit.create(MatchAPIService::class.java)}
}
