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
    ),
    Expenditure(
        id = 400,
        title = "4expenditure test title",
        user = "4Nazanin",
        paid = 200,
    ),
    Expenditure(
        id = 500,
        title = "5two",
        user = "5Phoebe",
        paid = 450,
    ),
    Expenditure(
        id = 600,
        title = "6third third..",
        user = "6Nazanin",
        paid = 1500,
    ),
    Expenditure(
        id = 700,
        title = "7expenditure test title",
        user = "7Nazanin",
        paid = 200,
    ),
    Expenditure(
        id = 800,
        title = "8two",
        user = "8Phoebe",
        paid = 450,
    ),
    Expenditure(
        id = 900,
        title = "9third third..",
        user = "9Nazanin",
        paid = 1500,
    )
)