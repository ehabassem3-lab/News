package com.example.compose_first.screens.maps

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapsWrapper(){
    var context = LocalContext.current
 var isEnabled  by remember { mutableStateOf(isGpsEnabled(context)) }
    var locationPermission = rememberMultiplePermissionsState(
      listOf(
          Manifest.permission.ACCESS_FINE_LOCATION ,
          Manifest.permission.ACCESS_COARSE_LOCATION
      ))
    var locationStatus = locationPermission.allPermissionsGranted


        Column(
            verticalArrangement = Arrangement.Center ,
            horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .clickable{
            Log.e("mapsMain","Maps Main entered")

        }
    ) {
            DisposableEffect(Unit) {
                locationPermission.launchMultiplePermissionRequest()



                onDispose { }
            }

            when {
                locationPermission.allPermissionsGranted -> {
                    Column() {
                        if (isEnabled){
                            MapsMain()
                        }

                        else{

                            Text(text =  "Gps is Disabled")

                            Button(onClick = {
                                isEnabled = isGpsEnabled(context)
                            }) {
                                Text("Refresh Status")

                            }

                        }
                    }
                }

                locationPermission.shouldShowRationale -> {
                    Column {
                        Text("We need these permissions to continue")

                        Button(onClick = {
                            locationPermission.launchMultiplePermissionRequest()
                        }) {
                            Text("Grant Permissions")
                        }
                    }
                }

                else -> {
                    Column {
                        Text("Permissions not granted ❌")

                        Button(onClick = {
                            val intent = Intent(
                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.fromParts("package", context.packageName, null)
                            )
                            context.startActivity(intent)
                        }) {
                            Text("Request Permissions")
                        }
                    }

                }


            }
        }




}