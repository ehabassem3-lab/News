package com.example.compose_first.screens.news

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose_first.models.ArticlesItem
import com.example.compose_first.viewmodels.SearchViewModel

@Composable
fun SearchedItem(sources : String?){
    val colorScheme = MaterialTheme.colorScheme
    var viewModel = hiltViewModel<SearchViewModel>()
    var isLoading = viewModel.isLoadingArticle.observeAsState()
    var isError = viewModel.isErrorArticle.observeAsState()
    var Articles = viewModel.ArticleSearched.observeAsState()
    var selectedArticle = remember {
        mutableStateOf<ArticlesItem?>(null)
    }
    DisposableEffect(sources) {
        viewModel.Search(sources?:"")

        onDispose {

        }
    }
    Column( modifier = Modifier
        .background(colorScheme.background).
        fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        LazyColumn (
            modifier = Modifier
                .background(colorScheme.background).
                fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            item{
                if (isLoading.value == true){
                    onLoading("The Articles Is Loading ")
                }
                if (isError?.value?.isNotEmpty() == true && Articles.value?.isEmpty() == null ){
                    onError("Try Again") {
                        viewModel.Search(sources?:"")







                    }
                }
            }
            if (Articles.value?.isEmpty() == true ){
                item {
                    emptyArticles("No Articles to Show")

                }

            }

            if ( !Articles.value.isNullOrEmpty()){
                items (Articles.value!!.size){ Article ->
                    Box(
                        modifier = Modifier.padding(10.dp).clickable{
                            selectedArticle.value = Articles.value!!.get(Article)

                        }
                    ){
                        NewsSingleITem(Articles.value!![Article])
                    }

                    Spacer(modifier = Modifier.size(10.dp))

                }
            }



        }
        if (selectedArticle.value != null){
            BottomBar(selectedArticle = selectedArticle)
        }
    }

}