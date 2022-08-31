package com.app.roomexamplehomework.screen.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.testexam.data.basehistory.ShowHistory
import com.app.testexam.presentation.ui.fragment.main.menu.payment.pay.ViewModelSend

class ViewModelFactory(private val listProduct: ShowHistory) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelSend::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ViewModelSend(listProduct) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}