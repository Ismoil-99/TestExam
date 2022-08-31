package com.app.testexam.presentation.ui.fragment.main.menu.payment.pay

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.testexam.data.basehistory.ShowHistory
import com.app.testexam.data.models.TransactionHistory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViewModelSend(private val showHistory: ShowHistory):ViewModel() {
    var allItems: LiveData<List<TransactionHistory>> = showHistory.getItems()
    fun addTransaction(transaction: TransactionHistory){
        Log.d("yes","yes")
        viewModelScope.launch(Dispatchers.IO) {
            showHistory.listProduct(transaction)
        }
    }
}