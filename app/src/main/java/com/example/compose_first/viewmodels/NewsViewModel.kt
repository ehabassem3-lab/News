package com.example.compose_first.viewmodels

import android.util.Log
import com.example.compose_first.domain.usecase.GetSourcesUseCase
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_first.api.ApiManager
import com.example.compose_first.database.SourcesDatabase
import com.example.compose_first.models.ArticelsResponse
import com.example.compose_first.models.ArticlesItem
import com.example.compose_first.models.SourcesItem
import com.example.compose_first.models.SourcesResponse
import com.example.compose_first.reposotories.NewsRepositoriesImpl
import com.example.compose_first.reposotories.offlineDataSourceImpl
import com.example.compose_first.reposotories.onlineDataSourceImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class  NewsViewModel @Inject constructor(
     val getSourcesUseCase: GetSourcesUseCase
): ViewModel(){



    var tabs  : MutableLiveData<List<SourcesItem>?> = MutableLiveData(null)

    var isLoadingSources  : MutableLiveData<Boolean> = MutableLiveData(false)
    var isErrorSources : MutableLiveData<String> = MutableLiveData(null)
    var Article : MutableLiveData<List<ArticlesItem>?> = MutableLiveData(null)

    var isLoadingArticle  : MutableLiveData<Boolean> = MutableLiveData(false)
    var isErrorArticle : MutableLiveData<String>  =    MutableLiveData(null)
    fun getResources(categories : String){

        isLoadingSources.value = true
        viewModelScope.launch {
            try {
                tabs.value  = getSourcesUseCase.repositorie.getSources(category =  categories)
                Log.e("Respone " , "Response${tabs.value }")

                isLoadingSources.value = false

            }
             catch (t : Throwable){
                 isLoadingSources.value = false
                  isErrorSources.value = t.message ;
                  Log.e("Faluire ","The Api Call Failed line number is 70"+t.message)
             }


        }

//

    }


    fun getArticles(source : String){
        isLoadingArticle.value = true

        viewModelScope.launch {
            try {
                var response =    ApiManager.apiService.getArticles(source =  source!!)
                Article.value = response.articles
                isLoadingArticle.value = false
            }
             catch ( t : Throwable){

                 isLoadingArticle.value = false
                    isErrorArticle.value = t.message
                    Log.e("Some Thing Went Wrong line 159","Articles Error "+t.message)
             }


        }

    }
}