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
)