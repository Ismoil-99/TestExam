package com.app.testexam.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_name")
data class TransactionHistory(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name = "nametransaction")
    val nameTransaction: String,
    @ColumnInfo(name = "imagecompany")
    val imageCompany: Int,
    @ColumnInfo(name = "idcount")
    val idCount: String,
    @ColumnInfo(name = "count")
    val count: String,
    @ColumnInfo(name = "time")
    val time: String
)
