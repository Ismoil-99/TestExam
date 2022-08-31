package com.app.testexam.data.basehistory

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.testexam.data.models.TransactionHistory

@Dao
interface ShowHistory {

    @Insert
    suspend fun listProduct(history:TransactionHistory)


    @Query("SELECT * FROM transaction_name")
    fun getItems(): LiveData<List<TransactionHistory>>

}