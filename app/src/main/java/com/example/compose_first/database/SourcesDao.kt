package com.example.compose_first.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.compose_first.models.SourcesItem

@Dao
interface SourcesDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  saveSources(sources :  List<SourcesItem>)

@Query("select  * from sourcesitem where category =:category ")
 suspend fun getSources(category : String) : List<SourcesItem>


}