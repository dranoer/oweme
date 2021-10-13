package com.dranoer.oweme.model

data class Expense(
    val title: String,
    val userCost: Int,
    val totalCost: Int,
    val peopleList: List<String>,
)

val mockExpenses = listOf(
    Expense(
        title = "Personal",
        userCost = 100,
        totalCost = 100,
        peopleList = listOf("Nazi")
    ),
    Expense(
        title = "House",
        userCost = 250,
        totalCost = 800,
        peopleList = listOf("Nazi", "Al")
    ),
    Expense(
        title = "Weekend",
        userCost = 700,
        totalCost = 2000,
        peopleList = listOf("Nazi", "Al", "Shahin")
    ),
)