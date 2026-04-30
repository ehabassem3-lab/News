package com.example.compose_first.screens.news

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.compose_first.models.ArticlesItem
import com.example.compose_first.ui.theme.DarkThemeTypography
import kotlinx.coroutines.launch
import androidx.core.net.toUri

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    selectedArticle: MutableState<ArticlesItem?>
) {
    val scope = rememberCoroutineScope()
    val colorScheme = MaterialTheme.colorScheme

    ModalBottomSheet(
        onDismissRequest = {
            selectedArticle.value = null
        },
        containerColor = colorScheme.onBackground
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorScheme.onBackground),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {
              BottomSingleItem(selectedArticle.value)
        }
    }
}
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BottomSingleItem(articels : ArticlesItem?){
    val context = LocalContext.current
    val colorScheme  = MaterialTheme.colorScheme
    Card ( border = BorderStroke(2.dp , color = colorScheme.onBackground),
        modifier = Modifier.fillMaxWidth(.9f).height(400.dp) ,
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.onBackground
        )
    ) {
        GlideImage(

            model = articels!!.urlToImage,
            contentDescription = "News Image",
            modifier = Modifier

                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .padding(5.dp)
                .align(Alignment.CenterHorizontally),

            )
        Text(
            articels?.description
                ?.replace(Regex("\\s+"), " ")
                ?.trim() ?:"",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .fillMaxHeight(.5f),
            style = DarkThemeTypography.bodySmall,
            color = colorScheme.background
        )
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, articels.url!!.toUri())
                    context.startActivity(intent)
                } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.background
                ) ,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp) ,
                shape = RoundedCornerShape(10.dp)

            ) {
                Text("View Full Article",      style = DarkThemeTypography.bodySmall,
                    color = colorScheme.onBackground
                )

            }

        }




}
