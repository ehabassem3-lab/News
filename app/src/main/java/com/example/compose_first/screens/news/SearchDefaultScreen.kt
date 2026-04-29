package com.example.compose_first.screens.news

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_first.ui.theme.DarkThemeTypography

@Composable
fun SearchDefaultScreen(
    modifier: Modifier = Modifier
){
    val colorScheme = MaterialTheme.colorScheme

    Column(
        Modifier.fillMaxSize().background(colorScheme.background),
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Outlined.Search ,
            contentDescription = "" ,
            tint =  colorScheme.onBackground ,
            modifier = Modifier.size(200.dp).alpha(.5f) ,

        )
        Spacer(Modifier.size(50.dp))
        Text(
           modifier =  Modifier.alpha(.8f) ,
            text = "Search Throw Thousands Of Articles ",
            color = colorScheme.onBackground ,
            style = DarkThemeTypography.bodyMedium.copy(fontSize = 20.sp)

        )

    }

}