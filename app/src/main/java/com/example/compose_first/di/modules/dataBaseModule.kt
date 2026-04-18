package com.example.compose_first.di.modules

import android.content.Context
import androidx.room.Room
import com.example.compose_first.database.SourcesDao
import com.example.compose_first.database.SourcesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

object dataBaseModule {
    @Provides
    fun provideDataBase(@ApplicationContext context : Context) : SourcesDatabase{

        return  Room.databaseBuilder(context ,SourcesDatabase::class.java,"dataBase")
            .fallbackToDestructiveMigration()
            .build()


    }
    @Provides
    fun provideDao( sourcesDatabase: SourcesDatabase) : SourcesDao{

        return  sourcesDatabase.getDao()


    }

}