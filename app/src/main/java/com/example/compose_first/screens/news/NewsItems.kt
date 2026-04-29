package com.example.compose_first.screens.news

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.compose_first.models.ArticlesItem
import com.example.compose_first.ui.theme.DarkThemeTypography
import com.example.compose_first.viewmodels.NewsViewModel


@Composable
fun NewsItems(sources : String?){
    val colorScheme  = MaterialTheme.colorScheme
   val viewModel = hiltViewModel<NewsViewModel>()
    var isLoading = viewModel.isLoadingArticle.observeAsState()
    var  isError = viewModel.isErrorArticle.observeAsState()
    var  Articles = viewModel.Article.observeAsState()
    DisposableEffect(sources) {
            viewModel.getArticles(sources?:"")

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
                   viewModel.getArticles(sources?:"")






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

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun NewsSingleITem(articels : ArticlesItem?){
    val colorScheme  = MaterialTheme.colorScheme
    Card ( border = BorderStroke(2.dp , color = colorScheme.onBackground),
        modifier = Modifier.fillMaxWidth(.9f).height(350.dp) ,
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.background
        )
    ) {
        GlideImage(

            model = articels!!.urlToImage,
            contentDescription = "News Image",
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
                .padding(5.dp)
                .align(Alignment.CenterHorizontally) ,

        )
        Text(
            articels?.title ?: "" , modifier = Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 10.dp)
                     , style = DarkThemeTypography.bodySmall ,
            color = colorScheme.onBackground
        )

        Row(
            horizontalArrangement = Arrangement.SpaceAround,


            modifier = Modifier.padding(start = 10.dp, top = 20.dp) ,
        ) {
            Text(
                articels?.author ?: "" ,  style = DarkThemeTypography.labelSmall)
            Spacer(modifier = Modifier.size(190.dp))
            Text(
                articels?.publishedAt ?: "",  style = DarkThemeTypography.labelSmall )

        }





    }

}

