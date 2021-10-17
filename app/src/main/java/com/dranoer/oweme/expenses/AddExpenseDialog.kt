package com.dranoer.oweme.expenses

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.dranoer.oweme.R


class AddExpenseDialog : DialogFragment() {

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

            val navHost: Fragment =
                requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main)!!
            val controller = NavHostFragment.findNavController(navHost)
            controller.navigate(R.id.navigation_expenditure_activity)
            dismiss()
        }
    }
}