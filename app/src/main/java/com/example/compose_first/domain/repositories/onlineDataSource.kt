package com.example.compose_first.domain.repositories

import com.example.compose_first.models.SourcesItem

interface onlineDataSource {
    suspend fun getSources(category : String) : List<SourcesItem>?

}