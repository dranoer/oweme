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

@Entity(tableName = "expenditure_table")
data class Expenditure(
    @PrimaryKey @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "user") val user: String,
    @ColumnInfo(name = "paid") val paid: Int,
//    @ColumnInfo(name = "expense") val expense: Expense?,
)

val mockExpenditure = listOf(
    Expenditure(
        id = 100,
        title = "expenditure test title",
        user = "Nazanin",
        paid = 200,
//        expense = null
    ),
    Expenditure(
        id = 200,
        title = "two",
        user = "Phoebe",
        paid = 450,
    ),
    Expenditure(
        id = 300,
        title = "third third..",
        user = "Nazanin",
        paid = 1500,
    )
)