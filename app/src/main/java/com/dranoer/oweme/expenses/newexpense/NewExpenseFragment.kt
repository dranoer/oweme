package com.dranoer.oweme.expenses.newexpense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.dranoer.oweme.databinding.FragmentNewExpenseBinding

class NewExpenseFragment : Fragment() {

    private var _binding: FragmentNewExpenseBinding? = null
    private val binding get() = _binding!!

    private lateinit var editExpenseView: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentNewExpenseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        editExpenseView = binding.editExpense

        binding.buttonSave.setOnClickListener {
        }

        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}