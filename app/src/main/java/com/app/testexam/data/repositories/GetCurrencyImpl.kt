package com.app.testexam.data.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.app.testexam.data.models.CurrencyAll
import com.app.testexam.data.models.CurrencyData
import com.app.testexam.data.remote.apicurrency.CurrencyApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class GetCurrencyImpl @Inject constructor (private val currency: CurrencyApi):GetCurrency {
    override fun getCurrency(): MutableLiveData<CurrencyAll> {
        val data = MutableLiveData<CurrencyAll>()
        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            try {
                val response = currency.getCurrency()
                if (response.isSuccessful) {
                    if (response.body() != null && response.code() == 200) {
                        data.postValue(response.body()!!)
                        Log.d("data","${response.body()}")
                    } else {
                        Log.d("data","${response.body()}")
                        //data.postValue(response.code())
                    }
                } else {

                    Log.d("data","${response.code()}")
                    //data.postValue(BaseUi.Error(message = response.code().toString()))
                }
            } catch (e: HttpException) {
                //data.postValue(BaseUi.Error(message = e.message.toString()))
            } catch (e: Throwable) {
                //data.postValue(BaseUi.Error(message = "Сервис недоступен"))
            }
        }
        return data
    }
}