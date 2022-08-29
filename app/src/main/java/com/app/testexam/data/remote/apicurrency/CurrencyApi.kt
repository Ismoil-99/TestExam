package com.app.testexam.data.remote.apicurrency

import com.app.testexam.data.models.CurrencyAll
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApi {
    @GET("latest/currencies/usd.json")
    suspend fun getCurrency(): Response<CurrencyAll>

}