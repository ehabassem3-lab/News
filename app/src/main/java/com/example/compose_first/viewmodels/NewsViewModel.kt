package com.example.compose_first.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.compose_first.api.ApiManager
import com.example.compose_first.models.ArticelsResponse
import com.example.compose_first.models.ArticlesItem
import com.example.compose_first.models.SourcesItem
import com.example.compose_first.models.SourcesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class  NewsViewModel : ViewModel(){
    var tabs  : MutableLiveData<List<SourcesItem>?> = MutableLiveData(null)

    var isLoadingSources  : MutableLiveData<Boolean> = MutableLiveData(false)
    var isErrorSources : MutableLiveData<String> = MutableLiveData(null)
    var Article : MutableLiveData<List<ArticlesItem>?> = MutableLiveData(null)

    var isLoadingArticle  : MutableLiveData<Boolean> = MutableLiveData(false)
    var isErrorArticle : MutableLiveData<String>  =    MutableLiveData(null)
    fun getResources(categories : String){

        isLoadingSources.value = true
        ApiManager.apiService.getSources(category =  categories).enqueue(
            object : Callback<SourcesResponse>{

                override fun onResponse(
                    call: Call<SourcesResponse?>,
                    response: Response<SourcesResponse?>
                ) {
                    isLoadingSources.value = false

                    if (response.isSuccessful) {
                        tabs.value = response.body()!!.sources

                        Log.e("SUCCESS", response.body().toString())
                        Log.e("SUCCESS", response.body().toString())
                    } else {
                        Log.e("ERROR", response.errorBody()?.string().toString())

                    }

                }

                override fun onFailure(
                    call: Call<SourcesResponse?>,
                    t: Throwable
                ) {
                    isLoadingSources.value = false
                    isErrorSources.value = t.message ;
                    Log.e("Faluire ","The Api Call Failed line number is 70"+t.message)
                }

            }

        )

    }


    fun getArticles(source : String){
        ApiManager.apiService.getArticles(source =  source!!).enqueue(

            object : Callback<ArticelsResponse>{
                override fun onResponse(
                    call: Call<ArticelsResponse?>,
                    response: Response<ArticelsResponse?>
                ) {
                    isLoadingArticle.value = false

                    if (response.isSuccessful){
                        Article.value = response.body()!!.articles
                        Log.e("Articels Body " , "${response.body()}")
                    }
                    else{
                        Log.e("Some Thing Went Wrong line 151","Articles Error ")
                        Log.e("Some Thing Went Wrong line 151","${response.code()}")
                        Log.e("ERROR", response.errorBody()?.string().toString())

                        isErrorArticle.value = "t.message"



                    }
                }

                override fun onFailure(
                    call: Call<ArticelsResponse?>,
                    t: Throwable
                ) {
                   isLoadingArticle.value = false
                    isErrorArticle.value = t.message
                    Log.e("Some Thing Went Wrong line 159","Articles Error "+t.message)
                }

            }

        )
    }
}