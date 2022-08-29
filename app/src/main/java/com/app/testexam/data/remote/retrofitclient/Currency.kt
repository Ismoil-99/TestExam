package com.app.testexam.data.remote.retrofitclient

import com.app.testexam.app.CURRENCY
import com.app.testexam.data.remote.apicurrency.CurrencyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Currency {
    private val retrofitClient: Retrofit = Retrofit.Builder()
        .baseUrl(CURRENCY)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun getRetrofitRequest(): CurrencyApi = retrofitClient.create(CurrencyApi::class.java)
}