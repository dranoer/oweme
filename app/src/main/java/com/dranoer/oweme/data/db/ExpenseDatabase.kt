package com.dranoer.oweme.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dranoer.oweme.data.model.Expense
import com.dranoer.oweme.data.model.mockExpenses
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Expense::class), version = 1, exportSchema = true)
abstract class ExpenseDatabase : RoomDatabase() {

    abstract fun expenseDao(): ExpenseDao

    private class ExpenseDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {

                    var expensedDao = database.expenseDao()

                    expensedDao.deleteAll()

                    expensedDao.insert(mockExpenses[0])
                    expensedDao.insert(mockExpenses[1])
                }
            }

        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ExpenseDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ExpenseDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpenseDatabase::class.java,
                    "expense_database"
                )
                    .addCallback(ExpenseDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // Return instance
                instance
            }
        }
    }
}