package com.dranoer.oweme.expenditure

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dranoer.oweme.R
import com.dranoer.oweme.data.model.Expenditure

class ExpenditureAdapter :
    ListAdapter<Expenditure, ExpenditureAdapter.ExpenditureViewHolder>(EXPENDITURE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenditureViewHolder {
        return ExpenditureViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ExpenditureViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(
            name = current.user,
            expenditureTitle = current.title,
            paid = current.paid.toString(),
        )
    }

    class ExpenditureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameItemView: TextView = itemView.findViewById(R.id.expenditure_name)
        private val expenditureItemView: TextView = itemView.findViewById(R.id.expenditure_title)
        private val paidItemView: TextView = itemView.findViewById(R.id.expenditure_paid)

        fun bind(name: String?, expenditureTitle: String?, paid: String?) {
            nameItemView.text = name
            expenditureItemView.text = expenditureTitle
            paidItemView.text = paid
        }

        companion object {
            fun create(parent: ViewGroup): ExpenditureViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.expenditure_item, parent, false)
                return ExpenditureViewHolder(view)
            }
        }
    }

    companion object {
        private val EXPENDITURE_COMPARATOR = object : DiffUtil.ItemCallback<Expenditure>() {
            override fun areItemsTheSame(oldItem: Expenditure, newItem: Expenditure): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Expenditure, newItem: Expenditure): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}