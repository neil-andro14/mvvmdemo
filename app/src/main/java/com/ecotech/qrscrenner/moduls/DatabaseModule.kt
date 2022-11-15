package com.ecotech.qrscrenner.moduls

import android.content.Context
import androidx.room.Room
import com.ecotech.qrscrenner.R
import com.ecotech.qrscrenner.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @Author: Nilesh Salunkhe
 * @Date: 13/10/22
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext mContext: Context): AppDatabase {
        return Room.databaseBuilder(mContext,AppDatabase::class.java,mContext.getString(R.string.app_name))
            .build()
    }
}