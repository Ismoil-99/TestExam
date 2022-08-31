package com.app.testexam.data.basehistory

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.testexam.data.models.TransactionHistory

@Database(entities = [TransactionHistory::class], version = 4, exportSchema = false)
abstract class BaseHistory : RoomDatabase() {

    abstract fun showHistory(): ShowHistory

    companion object {
        @Volatile
        private var INSTANCE: BaseHistory? = null

        fun getDatabase(context: Context): BaseHistory {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseHistory::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}