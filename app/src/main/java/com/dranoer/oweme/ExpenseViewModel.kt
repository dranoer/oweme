package com.dranoer.oweme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dranoer.oweme.model.Expense

class ExpenseViewModel : ViewModel() {

    private val _expenses = MutableLiveData<List<Expense>>()
    val expense: LiveData<List<Expense>> = _expenses

}