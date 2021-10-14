package com.dranoer.oweme.expenses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dranoer.oweme.ExpenseApplication
import com.dranoer.oweme.databinding.FragmentExpenseBinding

class ExpenseFragment : Fragment() {

    private val expenseViewModel: ExpenseViewModel by viewModels {
        ExpenseViewModelFactory((requireActivity().application as ExpenseApplication).repository)
    }

    private var _binding: FragmentExpenseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentExpenseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recyclerview
        val adapter = ExpenseAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        expenseViewModel.allExpenses.observe(viewLifecycleOwner) { expense ->
            expense.let { adapter.submitList(it) }
        }

        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}