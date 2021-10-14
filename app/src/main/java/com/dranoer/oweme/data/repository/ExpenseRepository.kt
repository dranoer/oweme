package com.dranoer.oweme.data.repository

import androidx.annotation.WorkerThread
import com.dranoer.oweme.data.db.ExpenseDao
import com.dranoer.oweme.data.model.Expense
import kotlinx.coroutines.flow.Flow

class ExpenseRepository(private val expenseDao: ExpenseDao) {

    val allExpenses: Flow<List<Expense>> = expenseDao.getExpenses()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(expense: Expense) {
        expenseDao.insert(expense)
    }

}