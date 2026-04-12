package com.example.compose_first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_first.routes.GeneralRoute
import com.example.compose_first.routes.SplashRoute
import com.example.compose_first.screens.News
import com.example.compose_first.screens.SplashScreen
import com.example.compose_first.ui.theme.Compose_FirstTheme


class MainActivity : ComponentActivity() {







    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

          setContent{

              Compose_FirstTheme() {
                  App()
              }

          }

    }
}
@Composable
fun App(

){

    var navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = GeneralRoute
    ) {
        composable<GeneralRoute> {
            News(navController)
        }
        composable<SplashRoute> {
            SplashScreen(navController)
        }

    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}