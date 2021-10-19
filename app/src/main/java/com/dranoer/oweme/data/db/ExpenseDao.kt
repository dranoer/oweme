package com.dranoer.oweme.data.db

import androidx.room.*
import com.dranoer.oweme.data.model.Expenditure
import com.dranoer.oweme.data.model.ExpenditureWithExpense
import com.dranoer.oweme.data.model.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {

    // Expense

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

    // Expenditure

    @Query("SELECT * FROM expenditure_table WHERE title = :expenditureTitle")
    fun getExpenditure(expenditureTitle: String): Expenditure

    @Query("SELECT * FROM expenditure_table")
    fun getExpenditures(): Flow<List<Expenditure>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExpenditure(expenditure: Expenditure)

    // 1-to-many relationship: expense-to-expenditure
    @Transaction
    @Query("SELECT * FROM expense_table")
    suspend fun getExpendituresWithExpense(): List<ExpenditureWithExpense>
}