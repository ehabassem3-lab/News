package com.example.compose_first.screens.news

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_first.ui.theme.DarkThemeTypography

@Composable
fun SearchComponent(
    onBackClick:()-> Unit,
    modifier : Modifier = Modifier,
    text : MutableState<String>,
    onSearchClick:()-> Unit){
    val colorScheme = MaterialTheme.colorScheme

    Card(
        Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 5.dp)
            .clip(CircleShape)
            .border(width = 2.dp, shape = CircleShape , color = colorScheme.onBackground) ,

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center ,


        ) {
            Icon(
                imageVector = Icons.Default.Search ,
                contentDescription = "" ,
                tint =  colorScheme.onBackground ,
                modifier = Modifier.padding(start = 20.dp, top = 10.dp).size(30.dp).clickable{
                    onSearchClick()
                }

            )
            Spacer(Modifier.size(20.dp))
            TextField(

                value = text.value,
                onValueChange = { text.value = it },
                placeholder = {
                    Text(text = "Search", style = DarkThemeTypography.bodySmall.copy(fontSize = 20.sp))
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = colorScheme.onBackground,
                    unfocusedTextColor = colorScheme.onBackground,

                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),

                textStyle = DarkThemeTypography.bodySmall
            )


            Icon(
                imageVector = Icons.Default.Close ,
                contentDescription = "" ,
                tint =  colorScheme.onBackground ,
                modifier = Modifier.size(40.dp).padding(start = 10.dp, top = 10.dp).clickable{
                    onBackClick()
                }

            )
        }

    }

}