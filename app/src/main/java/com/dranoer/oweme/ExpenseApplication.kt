package com.dranoer.oweme

import android.app.Application
import com.dranoer.oweme.data.db.ExpenseDatabase
import com.dranoer.oweme.data.repository.ExpenseRepository

class ExpenseApplication : Application() {

    val database by lazy { ExpenseDatabase.getDatabase(this) }
    val repository by lazy { ExpenseRepository(database.expenseDao()) }
}