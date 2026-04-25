package com.example.compose_first.screens.news

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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose_first.models.CategoriesModel
import com.example.compose_first.models.CategoriseList
import com.example.compose_first.ui.theme.DarkThemeTypography
import com.example.compose_first.ui.theme.Gray

@Composable
fun CategoriesTab(onCategoryClick:( category : CategoriesModel)-> Unit){
    val colorScheme = colorScheme


    LazyColumn (modifier = Modifier.fillMaxSize().background(colorScheme.background)){
        item{
            Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(.1f).padding(start = 10.dp)) {
                Text("Good Morning")

                Text("Here is Some News For You")
            }
        }
        itemsIndexed(CategoriseList){ index , category ->
            CategoriesItem(category , index ){
                onCategoryClick(category)
            }

        }



    }

}
@Composable
fun CategoriesItem( categoriesModel: CategoriesModel , index : Int , onClick:() -> Unit ){
    val colorScheme = colorScheme;
     var isEven = index % 2 == 0

         Box(modifier =
             Modifier
                 .  fillMaxHeight(.2f)
                 .padding(vertical = 5.dp , horizontal = 5.dp)
                 .fillMaxWidth()
                 .height(200.dp)
                 .clickable{onClick()}
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
            modifier = Modifier.fillMaxSize().padding(end = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Text(text =  Text , color =  colorScheme.background , style = DarkThemeTypography.headlineLarge)
            Spacer(modifier = Modifier.size(40.dp))
            Card  (
                modifier = Modifier.height(50.dp).width(150.dp).clip(shape = RoundedCornerShape(20.dp)) ,
                colors = CardDefaults.cardColors(
                    containerColor = Gray
                )



            ) {
                Row() {
                    Text(text =  "View All" ,
                        color =  colorScheme.onBackground ,
                        modifier = Modifier.padding(horizontal = 5.dp).align (Alignment.CenterVertically),
                    )

                    Icon(
                        imageVector =  Icons.AutoMirrored.Default.KeyboardArrowRight,
                        contentDescription = "" ,
                        modifier = Modifier.clip(CircleShape)
                            .fillMaxHeight()
                            .width(50.dp)
                            . background(colorScheme.background)
                            .align (Alignment.CenterVertically),
                        tint = colorScheme.onBackground
                    )
                }



            }

        }
    }
    else{

      Image(painter = painterResource(Image) , contentDescription = "" , modifier = Modifier.offset(x = 200.dp))
        Column(
            modifier = Modifier.fillMaxSize().padding(start = 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text =  Text , color =  colorScheme.background , style = DarkThemeTypography.headlineLarge )
            Spacer(modifier = Modifier.size(45.dp))
            Card  (
                modifier = Modifier.height(50.dp).width(150.dp).clip(shape = RoundedCornerShape(20.dp)) ,
                colors = CardDefaults.cardColors(
                    containerColor = Gray
                )



            ) {
                Row() {
                    Text(text =  "View All" ,
                        color =  colorScheme.onBackground ,
                        modifier = Modifier.padding(horizontal = 5.dp).align (Alignment.CenterVertically),
                        style = DarkThemeTypography.bodyLarge
                    )

                    Icon(
                        imageVector =  Icons.AutoMirrored.Default.KeyboardArrowRight,
                        contentDescription = "" ,
                        modifier = Modifier.clip(CircleShape)
                            .fillMaxHeight()
                            .width(50.dp)
                            . background(colorScheme.background)
                            .align (Alignment.CenterVertically),
                        tint = colorScheme.onBackground
                    )
                }



            }

        }

    }


}


