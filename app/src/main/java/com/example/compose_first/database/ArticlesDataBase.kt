package com.example.compose_first.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.compose_first.models.ArticlesItem
import com.example.compose_first.models.SourcesItem

@Database(entities =  [ArticlesItem::class] , version = 1)
abstract  class ArticlesDataBase  : RoomDatabase() {
    companion object{
        private  var myDataBase : ArticlesDataBase? = null
        fun createDataBase(context: Context){
            myDataBase =    Room.databaseBuilder(context ,ArticlesDataBase::class.java,"dataBase")
                .fallbackToDestructiveMigration()
                .build()

        }
        fun getDataBase()  : ArticlesDataBase{
            return myDataBase!!

        }

    }
    abstract fun getDao() : AriclesDao

}