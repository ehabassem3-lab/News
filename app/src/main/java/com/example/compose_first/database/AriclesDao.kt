package com.example.compose_first.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.compose_first.models.ArticlesItem
import com.example.compose_first.models.SourcesItem

@Dao
interface AriclesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  saveArticles(sources :  List<ArticlesItem>)

    @Query("select  * from articlesitem where name =:category ")
    suspend fun getSources(category : String) : List<ArticlesItem>
}