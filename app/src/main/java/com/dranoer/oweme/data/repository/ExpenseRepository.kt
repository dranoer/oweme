package com.dranoer.oweme.data.repository

import androidx.annotation.WorkerThread
import com.dranoer.oweme.data.db.ExpenseDao
import com.dranoer.oweme.data.model.Expenditure
import com.dranoer.oweme.data.model.Expense
import kotlinx.coroutines.flow.Flow

class ExpenseRepository(private val expenseDao: ExpenseDao) {

    val allExpenses: Flow<List<Expense>> = expenseDao.getExpenses()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(expense: Expense) {
        expenseDao.insert(expense)
    }

    @WorkerThread
    suspend fun getExpense(expenseTitle: String) {
        expenseDao.getExpense(expenseTitle)
    }

    @WorkerThread
    suspend fun updateExpense(expense: Expense) {
        expenseDao.updateExpense(expense)
    }

    // Expenditure

    val allExpenditure: Flow<List<Expenditure>> = expenseDao.getExpenditures()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertExpenditure(expenditure: Expenditure) {
        expenseDao.insertExpenditure(expenditure)
    }

    @WorkerThread
    suspend fun getExpenditure(expenditureTitle: String) {
        expenseDao.getExpenditure(expenditureTitle)
    }

    @WorkerThread
    suspend fun getExpendituresWithExpense() {
        expenseDao.getExpendituresWithExpense()
    }
}