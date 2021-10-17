package com.dranoer.oweme.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_table")
data class Expense(
    @PrimaryKey @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "totalCost") val totalCost: Int?,
    @ColumnInfo(name = "userCost") val userCost: Int?,
//    @ColumnInfo(name = "peopleList") val peopleList: List<String>,
)

val mockExpenses = listOf(
    Expense(
        title = "Personal",
        userCost = 100,
        totalCost = 100,
//        peopleList = listOf("Nazi")
    ),
    Expense(
        title = "House",
        userCost = 250,
        totalCost = 800,
//        peopleList = listOf("Nazi", "Al")
    ),
    Expense(
        title = "Weekend",
        userCost = 700,
        totalCost = 2000,
//        peopleList = listOf("Nazi", "Al", "Shahin")
    ),
)