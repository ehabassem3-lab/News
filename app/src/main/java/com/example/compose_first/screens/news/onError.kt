package com.example.compose_first.screens.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_first.ui.theme.DarkThemeTypography

@Composable
fun onError(massege : String , onRetry:  () -> Unit){
    val colorScheme = MaterialTheme.colorScheme
    Column (

        modifier = Modifier.fillMaxSize() ,
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement =  Arrangement.Center

    ){
        Text(
            massege ,
            style = DarkThemeTypography.bodyLarge.copy(color = colorScheme.onBackground)
        )
        Spacer(modifier = Modifier.size(20.dp))
        ElevatedButton( onClick =  {
            onRetry()
        } ,  modifier = Modifier.fillMaxWidth(.5f).fillMaxHeight(.1f)
        ) {
            Text("Retry ")

        }

    }
}
