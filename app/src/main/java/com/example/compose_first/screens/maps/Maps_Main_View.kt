package com.example.compose_first.screens.maps

import android.health.connect.datatypes.ExerciseRoute
import android.location.Location
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.maps.android.compose.GoogleMap
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapsMain(){

    val context = LocalContext.current
    var localClient  = remember { LocationServices.getFusedLocationProviderClient(context) }
    var currentLocation by remember { mutableStateOf<Location?>(null) }
    var isError by remember { mutableStateOf(false) }
    var cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(0.0,0.0),10f)
    }

    DisposableEffect(Unit) {
        localClient.getCurrentLocation(
            Priority.PRIORITY_HIGH_ACCURACY  ,
            CancellationTokenSource().token
        ).addOnSuccessListener {
            Log.e("Location Success","Successed${it}")
            currentLocation = it
            cameraPositionState.position = CameraPosition.fromLatLngZoom(
                LatLng(currentLocation!!.latitude , currentLocation!!.altitude),
                10f)
        }.addOnFailureListener {
            Log.e("Location Failure","failed")
            isError = true


        }


        onDispose {

        }
    }
    if (currentLocation == null) {
         Box(contentAlignment = Alignment.Center){
             CircularProgressIndicator()
         }
    }
    else{

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        )

    }
    if (isError) {
        FailedGetLocation(
            text = "Failed To Get Your Location "
        ){
            localClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY  ,
                CancellationTokenSource().token
            )
        }
    }


}