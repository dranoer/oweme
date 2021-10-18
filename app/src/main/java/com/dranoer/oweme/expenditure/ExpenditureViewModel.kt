package com.dranoer.oweme.expenditure

import androidx.lifecycle.*
import com.dranoer.oweme.data.model.Expenditure
import com.dranoer.oweme.data.repository.ExpenseRepository
import kotlinx.coroutines.launch

class ExpenditureViewModel(private val repository: ExpenseRepository) : ViewModel() {

    val allExpenditures: LiveData<List<Expenditure>> = repository.allExpenditure.asLiveData()

    fun insert(expenditure: Expenditure) = viewModelScope.launch {
        repository.insertExpenditure(expenditure)
    }

    fun getExpenditure(expenditureTitle: String) = viewModelScope.launch {
        repository.getExpenditure(expenditureTitle)
    }
}

class ExpenditureViewModelFactory(private val repository: ExpenseRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ExpenditureViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ExpenditureViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown viewModel class :(")
    }
}