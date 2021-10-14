package com.dranoer.oweme.expenses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dranoer.oweme.R
import com.dranoer.oweme.data.model.Expense

class ExpenseAdapter : ListAdapter<Expense, ExpenseAdapter.ExpenseViewHolder>(EXPENSS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        return ExpenseViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.title)
    }

    class ExpenseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val expenseItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            expenseItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): ExpenseViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.expense_item, parent, false)
                return ExpenseViewHolder(view)
            }
        }
    }

    companion object {
        private val EXPENSS_COMPARATOR = object : DiffUtil.ItemCallback<Expense>() {
            override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}