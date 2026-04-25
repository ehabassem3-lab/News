package com.example.compose_first.screens.maps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun FailedGetLocation(text : String, onRetry:() -> Unit){
    Column(
        modifier = Modifier.fillMaxSize() ,
        verticalArrangement =  Arrangement.Center ,
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Text(text )
        Button ( onClick = {onRetry()}) {
            Text("Try Again ")

        }
    }

}
