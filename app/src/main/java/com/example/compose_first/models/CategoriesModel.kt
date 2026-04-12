package com.example.compose_first.models

import com.example.compose_first.R

data class CategoriesModel(
    val CategorieTitle : String,
    val CategorieImage : Int

)
val CategoriseList  = listOf<CategoriesModel>(
    CategoriesModel("General" , R.drawable.ic_world),
    CategoriesModel("Business" , R.drawable.ic_bussnies),
    CategoriesModel("Sports" , R.drawable.ic_sports),
    CategoriesModel("Technology" , R.drawable.ic_technology),
    CategoriesModel("Entertainment" , R.drawable.ic_entertainment),

    CategoriesModel("Health" , R.drawable.ic_health),
    CategoriesModel("Science" , R.drawable.ic_sciemce),



    )
