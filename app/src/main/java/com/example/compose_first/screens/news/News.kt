package com.example.compose_first.screens.news

import DrawerContent
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.compose_first.R
import com.example.compose_first.models.CategoriesModel
import com.example.compose_first.routes.SearchRoute
import com.example.compose_first.routes.ThemesRoute
import com.example.compose_first.viewmodels.SearchViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun News(navController: NavController) {
    var selctedCategory by remember { mutableStateOf<CategoriesModel?>(null) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    var isThemeClicked = false

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(
                OnHomeClick = {
                    selctedCategory = null
                    isThemeClicked = false
                    scope.launch {
                        drawerState.close()
                    }

                },
                OnThemeClick = {
                    scope.launch {
                        drawerState.close()
                        navController.navigate(ThemesRoute)
                    }

                }

            )



        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {


                    TopAppBar(

                        title =  if (selctedCategory == null)"Home" else "General",
                        onMenuClick = {
                            scope.launch { drawerState.open() }
                        }  ,
                        onSearchClick = {
                            navController.navigate(SearchRoute)


                        }

                    )
            }
        ) { innerPadding ->


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {




                if (selctedCategory != null){
                    NewsTabs(selctedCategory!!)
                }

                else{

                   CategoriesTab(){
                       selctedCategory = it

                 }
                }



            }
        }
    }
}