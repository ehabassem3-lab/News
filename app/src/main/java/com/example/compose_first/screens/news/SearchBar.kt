package com.example.compose_first.screens.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose_first.routes.GeneralRoute
import com.example.compose_first.viewmodels.SearchViewModel


@Composable
fun SearchScreen(navController: NavController){

    val colorScheme = MaterialTheme.colorScheme
    var text : MutableState<String> =  remember { mutableStateOf("") }
    var searchClicked by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            Column(
                modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
            ) {
                SearchComponent(
                    text = text ,
                    onBackClick =  {
                        if (!text.value.isEmpty()){
                            text.value = ""


                        }
                        else{
                            navController.navigate(GeneralRoute)
                        }

                    } , onSearchClick = {
                        searchClicked = true

                    })

            }
        },
        modifier = Modifier.fillMaxSize().background(colorScheme.background)
    ) {innerPadding->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorScheme.background)
                .padding(innerPadding)
        ) {

            if (searchClicked){
                SearchedItem(text.value)
            }
            else{
                SearchDefaultScreen()
            }

        }

    }




}