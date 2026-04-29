package com.example.compose_first.screens.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose_first.R
import com.example.compose_first.ui.theme.DarkThemeTypography


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String,
    onMenuClick: () -> Unit ,
    onSearchClick: () -> Unit
) {


    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = DarkThemeTypography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
        },
        navigationIcon = {
            Image(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .size(40.dp)
                    .clickable(onClick = onMenuClick),
                painter = painterResource(R.drawable.ic_hamburger),
                contentDescription = "Menu",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
            )
        },
        actions = {
            Image(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(30.dp)
                    .clickable{
                          onSearchClick()
                    },
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search",
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}

