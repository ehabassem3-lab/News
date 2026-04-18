package com.example.compose_first.reposotories

import android.util.Log
import com.example.compose_first.database.SourcesDao
import com.example.compose_first.domain.repositories.offlineDataSource
import com.example.compose_first.models.SourcesItem
import java.util.Locale.getDefault
import javax.inject.Inject

class offlineDataSourceImpl @Inject constructor  (var dao : SourcesDao): offlineDataSource{

   override  suspend fun getSources(category : String) : List<SourcesItem>{

              var sources = dao.getSources(category.lowercase(getDefault()))
         Log.e("Saved " ,"Saved${sources}")
         return sources

     }
    override  suspend fun saveSources(category : String , sources :  List<SourcesItem>) {

         dao.saveSources(   sources)
         Log.e("Saved " ,"Saved${sources}")





     }

 }
