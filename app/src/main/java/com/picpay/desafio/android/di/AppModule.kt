package com.picpay.desafio.android.di

import com.picpay.desafio.android.api.RetrofitInstance
import com.picpay.desafio.android.api.cache.PicPayCache
import com.picpay.desafio.android.repository.MainActivityRepository
import com.picpay.desafio.android.repository.MainActivityRepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitIntance(): RetrofitInstance{
        return RetrofitInstance()
    }

    @Provides
    @Singleton
    fun provideMainActivityRepository(retrofitInstance: RetrofitInstance): MainActivityRepositoryInterface{
        return MainActivityRepository(retrofitInstance)
    }

    @Provides
    @Singleton
    fun providePicPayCache(): PicPayCache{
        return PicPayCache
    }

}