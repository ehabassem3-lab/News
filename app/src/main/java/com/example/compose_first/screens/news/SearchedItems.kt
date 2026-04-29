package com.example.compose_first.screens.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.compose_first.viewmodels.SearchViewModel

@Composable
fun SearchedItem(sources : String?){
    val colorScheme = MaterialTheme.colorScheme
    var viewModel = hiltViewModel<SearchViewModel>()
    var isLoading = viewModel.isLoadingArticle.observeAsState()
    var isError = viewModel.isErrorArticle.observeAsState()
    var Articles = viewModel.ArticleSearched.observeAsState()
    DisposableEffect(sources) {
        viewModel.Search(sources?:"")

        onDispose {

        }
    }
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
                NewsSingleITem(Articles.value!![Article])
                Spacer(modifier = Modifier.size(10.dp))

            }
        }



    }
}