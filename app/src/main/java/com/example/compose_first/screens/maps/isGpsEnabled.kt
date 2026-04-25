package com.example.compose_first.screens.maps
import android.content.Context
import android.location.LocationManager
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

fun isGpsEnabled(context: Context): Boolean {
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
}
