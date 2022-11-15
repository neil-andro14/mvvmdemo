package com.ecotech.qrscrenner.moduls

import com.ecotech.qrscrenner.dao.MainDao
import com.ecotech.qrscrenner.network.APIServices
import com.ecotech.qrscrenner.repositories.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @Author: Nilesh Salunkhe
 * @Date: 18/10/22
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryProviderModule {

    @Provides
    fun provideMainRepository(mainDao:MainDao,apiServices: APIServices): MainRepository = MainRepository(mainDao,apiServices)
}