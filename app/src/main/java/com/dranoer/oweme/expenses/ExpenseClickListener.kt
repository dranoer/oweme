package com.dranoer.oweme.expenses

import com.dranoer.oweme.data.model.Expense

interface ExpenseClickListener {
    fun onExpenseClicked(expense: Expense)
}