package com.example.compose_first.reposotories

import android.util.Log
import com.example.compose_first.api.ApiServices
import com.example.compose_first.domain.repositories.onlineDataSource
import com.example.compose_first.models.SourcesItem
import javax.inject.Inject

class onlineDataSourceImpl @Inject constructor (var services: ApiServices ) : onlineDataSource{
   override suspend fun getSources(category : String) : List<SourcesItem>? {
       var response = services.getSources(category= category).sources
        Log.e("Repo ","Repo Response${response}")

        return  response
    }
}
