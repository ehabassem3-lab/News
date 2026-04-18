package com.example.compose_first.di.modules

import com.example.compose_first.domain.repositories.NewsRepo
import com.example.compose_first.domain.repositories.offlineDataSource
import com.example.compose_first.domain.repositories.onlineDataSource
import com.example.compose_first.reposotories.NewsRepositoriesImpl
import com.example.compose_first.reposotories.offlineDataSourceImpl
import com.example.compose_first.reposotories.onlineDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
 abstract  class AppModule {

     @Binds
     abstract fun bindNewsRepo(args: NewsRepositoriesImpl) : NewsRepo
    @Binds
    abstract fun bindOnlineData(args: onlineDataSourceImpl) : onlineDataSource
    @Binds
    abstract fun bindOfflineData(args: offlineDataSourceImpl) : offlineDataSource



}