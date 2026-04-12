package com.example.compose_first.screens

import androidx.compose.foundation.Image

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose_first.R
import com.example.compose_first.models.CategoriesModel
import com.example.compose_first.models.CategoriseList
import com.example.compose_first.ui.theme.Black
import com.example.compose_first.ui.theme.Gray
import com.example.compose_first.ui.theme.White

@Composable
fun CategoriesTab(){
    val colorScheme = MaterialTheme.colorScheme
    LazyColumn (modifier = Modifier.fillMaxSize().background(colorScheme.background)){
        itemsIndexed(CategoriseList){ index , category ->
            CategoriesItem(category , index)

        }



    }

}
@Composable
fun CategoriesItem( categoriesModel: CategoriesModel , index : Int ){
    val colorScheme = MaterialTheme.colorScheme
     var isEven = index % 2 == 0
         Box(modifier =
             Modifier
                 .  fillMaxHeight(.2f)
                 .padding(vertical = 10.dp , horizontal = 10.dp)
                 .fillMaxWidth()
                 .height(200.dp)
                 .padding(vertical = 10.dp)
                 .clip(RoundedCornerShape(25.dp))
                 .background(colorScheme.onBackground)


         ){

                 ItemDirection(isEven =  isEven , Image = categoriesModel.CategorieImage , categoriesModel.CategorieTitle)





         }

}
@Composable
fun ItemDirection( isEven : Boolean  , Image : Int ,  Text : String){
    if (isEven){
        Image(painter =  painterResource(Image) , contentDescription = ""  )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Text(text =  Text , color =  colorScheme.background)
            Spacer(modifier = Modifier.size(40.dp))
            Row  (
                modifier = Modifier.background(Gray).clip(CircleShape)

            ) {
                Text(text =  "View All" , color =  colorScheme.onBackground)

                Icon(
                    imageVector =  Icons.AutoMirrored.Default.KeyboardArrowRight,
                    contentDescription = "" ,
                    modifier = Modifier.clip(CircleShape)
                        .size(40.dp)
                        . background(colorScheme.background) ,
                    tint = colorScheme.onBackground
                )


            }

        }
    }
    else{

      Image(painter = painterResource(Image) , contentDescription = "" , modifier = Modifier.offset(x = 190.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text =  Text , color =  colorScheme.background)
            Spacer(modifier = Modifier.size(40.dp))
            Row  (
                modifier = Modifier.background(Gray).clip(CircleShape)

            ) {
                Text(text =  "View All" , color =  colorScheme.onBackground)

                Icon(
                    imageVector =  Icons.AutoMirrored.Default.KeyboardArrowRight,
                    contentDescription = "" ,
                    modifier = Modifier.clip(CircleShape)
                        .size(40.dp)
                        . background(colorScheme.background) ,
                    tint = colorScheme.onBackground
                )


            }

        }

    }


}


