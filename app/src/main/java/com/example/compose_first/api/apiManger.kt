package com.example.compose_first.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    companion object {
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("X-Api-Key", API_KEY)
                    .addHeader("User-Agent", "Mozilla/5.0")
                    .addHeader("Accept", "application/json")
                    .build()
                chain.proceed(request)
            }
            .build()
         const val API_KEY = "728f9527d06d4edca3c6981178b4861e"
        private const val BASE_URL = "https://newsapi.org/"

        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client) // 🔥 IMPORTANT
                .build()
        }

        val apiService: ApiServices by lazy {
            retrofit
                .create(ApiServices::class.java)
        }
    }
}