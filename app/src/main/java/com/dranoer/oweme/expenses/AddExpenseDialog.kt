package com.dranoer.oweme.expenses

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dranoer.oweme.ExpenseApplication
import com.dranoer.oweme.R
import com.dranoer.oweme.data.model.Expense

class AddExpenseDialog : DialogFragment() {

    private val expenseViewModel: ExpenseViewModel by viewModels {
        ExpenseViewModelFactory((requireActivity().application as ExpenseApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.round_corner)
        return inflater.inflate(R.layout.fragment_new_expense, container, false)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

        val saveButton = dialog!!.findViewById<View>(R.id.button_save) as Button
        saveButton.setOnClickListener {
            Log.d("expense_dialog", "saved pressed successfully")

            val titleTv: EditText = requireView().findViewById(R.id.edit_expense)
            val title = titleTv.text.toString()

            expenseViewModel.insert(
                Expense(
                    title = title,
                    totalCost = null,
                    userCost = null,
                )
            )

            val navHost: Fragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)!!
            val action = ExpenseFragmentDirections.actionAddExpenseToExpenditure(title)
            navHost.findNavController().navigate(action)

            dismiss()
        }
    }
}