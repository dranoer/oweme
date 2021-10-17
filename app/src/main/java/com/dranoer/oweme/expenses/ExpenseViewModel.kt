package com.dranoer.oweme.expenses

import androidx.lifecycle.*
import com.dranoer.oweme.data.model.Expense
import com.dranoer.oweme.data.repository.ExpenseRepository
import kotlinx.coroutines.launch

class ExpenseViewModel(private val repository: ExpenseRepository) : ViewModel() {

    val allExpenses: LiveData<List<Expense>> = repository.allExpenses.asLiveData()

    fun insert(expense: Expense) = viewModelScope.launch {
        repository.insert(expense)
    }

    fun getExpense(expenseTitle: String) = viewModelScope.launch {
        repository.getExpense(expenseTitle)
    }

    fun updateExpense(expense: Expense) = viewModelScope.launch {
        repository.updateExpense(expense)
    }
}

class ExpenseViewModelFactory(private val repository: ExpenseRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExpenseViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExpenseViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown viewModel class :(")
    }
}