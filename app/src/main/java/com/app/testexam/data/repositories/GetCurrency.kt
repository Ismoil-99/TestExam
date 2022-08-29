package com.app.testexam.data.repositories

import androidx.lifecycle.LiveData
import com.app.testexam.data.models.CurrencyAll
import com.app.testexam.data.models.CurrencyData

interface GetCurrency {
    fun getCurrency(): LiveData<CurrencyAll>
}