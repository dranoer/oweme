package com.dranoer.oweme.data.db

import androidx.room.*
import com.dranoer.oweme.data.model.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expense_table WHERE title = :expenseTitle")
    fun getExpense(expenseTitle: String): Expense

    @Query("SELECT * FROM expense_table")
    fun getExpenses(): Flow<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(expense: Expense)

    @Query("DELETE FROM expense_table")
    suspend fun deleteAll()

    @Update
    suspend fun updateExpense(expense: Expense)
}