package com.ecotech.qrscrenner.moduls

import com.ecotech.qrscrenner.BuildConfig
import com.ecotech.qrscrenner.network.APIServices
import com.ecotech.qrscrenner.network.WebServices.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @Author: Nilesh Salunkhe
 * @Date: 19/10/22
 *
 */

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {


    @Provides
    fun provideBaseURL():String = BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(okHttpClient: OkHttpClient,baseURL:String): Retrofit= Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .baseUrl(baseURL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit) = retrofit.create(APIServices::class.java)


    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }
}