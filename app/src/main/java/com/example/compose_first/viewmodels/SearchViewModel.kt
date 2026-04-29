package com.example.compose_first.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_first.domain.usecase.GetSourcesUseCase
import com.example.compose_first.domain.usecase.SearchArticlesUseCase
import com.example.compose_first.models.ArticlesItem
import com.example.compose_first.models.SourcesItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SearchViewModel@Inject constructor(
    val searchArticlesUseCase: SearchArticlesUseCase ,
    ) : ViewModel() {
    var isLoadingArticle  : MutableLiveData<Boolean> = MutableLiveData(false)
    var isErrorArticle : MutableLiveData<String>  =    MutableLiveData(null)
    var ArticleSearched : MutableLiveData<List<ArticlesItem>> = MutableLiveData(null)


    fun Search(name : String?  ){
        viewModelScope.launch {
            isLoadingArticle.value = true
            try {
             var searched =    searchArticlesUseCase.execute(category =  name?:"")
                ArticleSearched.value =  searched
                Log.e("Success ","Error Getting the Search ${searched}")
                isLoadingArticle.value = false




            }
            catch (T  : Throwable){
                isLoadingArticle.value = false
                isErrorArticle.value = T.message
                Log.e("Error ","Error Getting the Search ${T.message}")
            }

        }


    }
}