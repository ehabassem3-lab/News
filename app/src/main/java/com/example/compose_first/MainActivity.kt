package com.example.compose_first

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_first.routes.GeneralRoute
import com.example.compose_first.routes.MapsAppRoute
import com.example.compose_first.routes.SplashRoute
import com.example.compose_first.routes.ThemesRoute
import com.example.compose_first.screens.maps.MapsWrapper
import com.example.compose_first.screens.news.News
import com.example.compose_first.screens.news.SplashScreen
import com.example.compose_first.screens.news.changeTheme
import com.example.compose_first.ui.theme.Compose_FirstTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

          setContent{
              var darkTheme by remember {
                  mutableStateOf(false)
              }

              Compose_FirstTheme(
                  darkTheme = darkTheme
              ) {
                  App(
                      isDarkTheme = darkTheme,
                      onThemeChange = {
                          darkTheme = it
                      }
                  )
              }

          }

    }
}

@Composable
fun App(
    isDarkTheme: Boolean,
    onThemeChange: (Boolean) -> Unit
){

    var navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = ThemesRoute
    ) {
        composable<GeneralRoute> {
            News(navController)
        }
        composable<SplashRoute> {
            SplashScreen(navController)
        }
        composable<MapsAppRoute> {
            MapsWrapper( )
        }
        composable <ThemesRoute>{
            changeTheme(
                navController,
              isDarkTheme = isDarkTheme,
                onThemeChange = onThemeChange
            )
        }

    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {


}