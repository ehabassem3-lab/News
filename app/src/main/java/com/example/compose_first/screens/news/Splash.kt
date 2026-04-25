package com.example.compose_first.screens.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose_first.R

@Composable
fun SplashScreen(
    navController: NavController

){
    val colorScheme = MaterialTheme.colorScheme
    Box(
        modifier =  Modifier
            .fillMaxSize()
            .background(colorScheme.background)
            ,
        contentAlignment = Alignment.Center
    ){

        Image(
            modifier = Modifier.fillMaxHeight(.3f).background(colorScheme.background),
            contentScale = ContentScale.FillHeight,
            painter = painterResource(R.drawable.ic_splash_logo),
            contentDescription = "",
            colorFilter = ColorFilter.tint(colorScheme.onBackground)


        )
        Image(
            colorFilter = ColorFilter.tint(colorScheme.onBackground),
            modifier = Modifier.padding(bottom = 50.dp).align(Alignment.BottomCenter).fillMaxHeight(.1f),
              contentScale = ContentScale.FillHeight,
            painter = painterResource(R.drawable.ic_splash_signture) ,
            contentDescription = ""
        )






    }
}