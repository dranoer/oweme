package com.dranoer.oweme

import android.app.Application
import com.dranoer.oweme.data.db.ExpenseDatabase
import com.dranoer.oweme.data.repository.ExpenseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ExpenseApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { ExpenseDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { ExpenseRepository(database.expenseDao()) }
}