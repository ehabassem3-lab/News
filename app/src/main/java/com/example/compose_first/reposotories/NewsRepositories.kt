package com.example.compose_first.reposotories

import android.util.Log
import com.example.compose_first.api.ApiManager
import com.example.compose_first.api.ApiServices
import com.example.compose_first.domain.repositories.NewsRepo
import com.example.compose_first.domain.repositories.offlineDataSource
import com.example.compose_first.domain.repositories.onlineDataSource
import com.example.compose_first.models.ArticlesItem
import com.example.compose_first.models.SourcesItem
import javax.inject.Inject

class NewsRepositoriesImpl  @Inject constructor (

    var offlineDataSource : offlineDataSource,
    var onlineDataSource : onlineDataSource
): NewsRepo {



    override suspend fun getSources(category : String) : List<SourcesItem>{
        if (true){
            val source = onlineDataSource.getSources(category)
            offlineDataSource.saveSources(category , source!!)
            Log.e("Saved " ,"Saved${ offlineDataSource.saveSources(category , source!!)}")
            return source
        }
        else{
           return  offlineDataSource.getSources(category)
        }






    }

    override suspend fun searchSources(category: String): List<ArticlesItem> {
        val search = ApiManager.apiService.searchArticles(category).articles
        Log.e("Search Results ","Search Results ${search}")
        return  search!!

    }


}