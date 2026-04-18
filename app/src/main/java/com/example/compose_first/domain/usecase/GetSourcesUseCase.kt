package com.example.compose_first.domain.usecase
import com.example.compose_first.domain.repositories.NewsRepo
import com.example.compose_first.models.SourcesItem
import javax.inject.Inject

class GetSourcesUseCase @Inject constructor ( var repositorie : NewsRepo ){

    suspend fun execute(category  : String ) : List<SourcesItem>{
        return repositorie.getSources(category)
    }
}

