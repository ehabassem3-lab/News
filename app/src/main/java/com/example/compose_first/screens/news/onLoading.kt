package com.example.compose_first.screens.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_first.ui.theme.DarkThemeTypography

@Composable
fun onLoading(massege : String){
    val colorScheme = MaterialTheme.colorScheme
    Column (
        modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        CircularProgressIndicator()
        Spacer(modifier = Modifier.size(40.dp))
        Text(massege , style = DarkThemeTypography.bodyMedium , color = colorScheme.onBackground)

    }


}