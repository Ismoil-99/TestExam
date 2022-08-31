package com.app.testexam.presentation.ui.fragment.main.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.testexam.data.basehistory.ShowHistory
import com.app.testexam.data.models.TransactionHistory

class HistoryViewModel (private val showHistory: ShowHistory) :ViewModel() {
    var allItems: LiveData<List<TransactionHistory>> = showHistory.getItems()
}