package com.example.compose_first.domain.repositories

import com.example.compose_first.models.SourcesItem

interface offlineDataSource {
    suspend fun saveSources(category : String , sources :  List<SourcesItem>)
    suspend fun getSources(category : String) : List<SourcesItem>
}