package com.example.compose_first.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose_first.api.ApiManager
import com.example.compose_first.api.ApiServices
import com.example.compose_first.models.CategoriesModel
import com.example.compose_first.models.SourcesItem
import com.example.compose_first.models.SourcesResponse
import com.example.compose_first.ui.theme.DarkThemeTypography
import com.example.compose_first.viewmodels.NewsViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun NewsTabs(categories: CategoriesModel) {
    val colorScheme = MaterialTheme.colorScheme
    var selectedTabIndex by remember { mutableStateOf(0) }
    var viewModel =  viewModel<NewsViewModel>()
    val isLoading = viewModel.isLoadingSources.observeAsState()
    val isError = viewModel.isErrorSources.observeAsState()
    val tabs = viewModel.tabs.observeAsState()



    DisposableEffect(categories) {
            viewModel.getResources(categories.CategorieTitle)

        onDispose {  }
    }





               Column(
                   modifier = Modifier.fillMaxWidth()
               ) {
                   if (isLoading.value == true) {

                       onLoading("The News Is Loaing")
                   }
                   if (isError.value?.isEmpty() == true) {


                       onError("Something Went Wrong") {

                           viewModel.getResources(categories.CategorieTitle)


                       }



                   }
                   if (!tabs.value.isNullOrEmpty()) {
                       ScrollableTabRow(
                           selectedTabIndex = selectedTabIndex,
                           indicator = { tabPositons ->
                               Box(
                                   modifier = Modifier
                                       .tabIndicatorOffset(tabPositons[selectedTabIndex])
                                       .height(2.dp)
                                       .background(colorScheme.onBackground)
                               )


                           },
                           divider = {

                           }


                       ) {
                           for (i in 0 until (tabs?.value?.size ?: -1)) {
                               var isSlected = selectedTabIndex == i
                               Tab(
                                   modifier = Modifier.padding(horizontal = 10.dp),
                                   selected = selectedTabIndex == i,
                                   onClick = {
                                       selectedTabIndex = i
                                   }
                               ) {
                                   Text(
                                       text = tabs.value!![i].name ?: "",
                                       color = colorScheme.onBackground,
                                       modifier = Modifier.padding(2.dp),
                                       style =
                                           if (isSlected) DarkThemeTypography.bodyLarge else DarkThemeTypography.bodyMedium.copy(
                                               fontWeight = FontWeight.Normal,
                                               fontSize = 14.sp
                                           )
                                   )
                               }
                           }
                       }
                       Spacer(modifier = Modifier.size(20.dp))
                       NewsItems(sources =tabs.value!![selectedTabIndex].id)
                       Log.e("ERROR", "${tabs.value!![selectedTabIndex].id}")

                   }


               }
}