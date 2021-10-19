package com.dranoer.oweme.expenditure

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.dranoer.oweme.ExpenseApplication
import com.dranoer.oweme.R
import com.dranoer.oweme.data.model.Expenditure

class AddExpenditureDialog : DialogFragment() {

    private val expenditureViewModel: ExpenditureViewModel by viewModels {
        ExpenditureViewModelFactory((requireActivity().application as ExpenseApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.round_corner)
        return inflater.inflate(R.layout.fragment_new_expenditure, container, false)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

        val saveButton = dialog!!.findViewById<View>(R.id.button_save_expenditure) as Button
        saveButton.setOnClickListener {
            Log.d("expenditure_dialog", "saved pressed successfully")

            val titleTv: EditText = requireView().findViewById(R.id.expenditure_title)
            val amountTv: EditText = requireView().findViewById(R.id.expenditure_amount)
            val byTv: EditText = requireView().findViewById(R.id.expenditure_by)
            val forTv: EditText = requireView().findViewById(R.id.expenditure_for)

            val title = titleTv.text.toString()
            val paid = amountTv.text.toString().toInt()
            val user = byTv.text.toString()

            expenditureViewModel.insert(
                Expenditure(
                    title = title,
                    user = user,
                    paid = paid,
                )
            )

            dismiss()
        }
    }
}