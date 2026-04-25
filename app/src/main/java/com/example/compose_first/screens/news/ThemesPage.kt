package com.example.compose_first.screens.news

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.DatePicker
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose_first.routes.GeneralRoute
import com.example.compose_first.ui.theme.DarkThemeTypography

@Composable
 fun changeTheme(
    navController: NavController ,
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
 ){
     val colorScheme = MaterialTheme.colorScheme
    Scaffold(
        topBar = {
            Box(
                modifier = Modifier.background(colorScheme.background)



            )
            {
                Row(
                    modifier = Modifier.fillMaxWidth() ,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Favorite icon",
                        tint = colorScheme.onBackground ,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(40.dp)
                            .clickable{
                                navController.navigate(GeneralRoute)
                            }
                    )
                    Text(
                        "Themes",
                        style = DarkThemeTypography.headlineLarge.copy(color = colorScheme.onBackground) ,
                        modifier = Modifier.padding(10.dp)

                    )
                    Text(
                        "Themes",
                        style = DarkThemeTypography.headlineLarge.copy(color = colorScheme.background)

                    )

                }
            }
        }
    ) {innerPadding ->
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(colorScheme.background)
                    .padding(top = 50.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                Text("Change The Theme ", color = colorScheme.onBackground, modifier = Modifier.padding(top = 10.dp))
              Spacer(modifier = Modifier.size(20.dp))
                SwitchButton(
                    isDarkTheme = isDarkTheme,
                    onThemeChange = onThemeChange
                )


            }





        }




    }

 }


