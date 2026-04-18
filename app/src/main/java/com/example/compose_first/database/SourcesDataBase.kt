package com.example.compose_first.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.compose_first.models.SourcesItem

@Database(entities =  [SourcesItem::class] , version = 1)
abstract  class SourcesDatabase  : RoomDatabase() {
           companion object{
               private  var myDataBase : SourcesDatabase? = null
               fun createDataBase(context: Context){
                   myDataBase =    Room.databaseBuilder(context ,SourcesDatabase::class.java,"dataBase")
                       .fallbackToDestructiveMigration()
                       .build()

               }
               fun getDataBase()  : SourcesDatabase{
                   return myDataBase!!

               }

           }
    abstract fun getDao() : SourcesDao

}