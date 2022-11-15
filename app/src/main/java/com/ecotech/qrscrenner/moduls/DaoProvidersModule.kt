package com.ecotech.qrscrenner.moduls

import com.ecotech.qrscrenner.dao.MainDao
import com.ecotech.qrscrenner.database.AppDatabase
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
object DaoProvidersModule {

    @Provides
    fun providesMainDao(appDatabase: AppDatabase): MainDao= appDatabase.mainDao()
}