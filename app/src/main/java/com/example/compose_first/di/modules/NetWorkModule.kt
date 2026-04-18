package com.example.compose_first.di.modules

import com.example.compose_first.api.ApiManager.Companion.client
import com.example.compose_first.api.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)

 object   NetWorkModule {
     @Provides
     fun provideConverterFactory() : GsonConverterFactory{
          return GsonConverterFactory.create()
     }

    @Provides
    fun provideRetrofit( gsonConverterFactory: GsonConverterFactory ) : Retrofit{
      return   Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(gsonConverterFactory )
            .client(client) // 🔥 IMPORTANT
            .build()

    }

    @Provides
     fun provideWeb( retrofit: Retrofit ) : ApiServices{

         return  retrofit.create(ApiServices::class.java)


     }

}