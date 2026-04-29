package com.example.compose_first.api

import com.example.compose_first.api.ApiManager.Companion.API_KEY
import com.example.compose_first.models.ArticelsResponse
import com.example.compose_first.models.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {


    @GET("v2/top-headlines/sources")
   suspend fun getSources(
        @Query("category") category: String
    ) : SourcesResponse


    @GET("v2/top-headlines")
    suspend fun searchArticles(
        @Query("category") category: String
    ) : ArticelsResponse

     @GET("v2/everything")
     suspend fun getArticles
                 (
       @Query("sources")  source : String
    ) : ArticelsResponse



}