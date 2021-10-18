package com.dranoer.oweme.expenditure

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import com.dranoer.oweme.ExpenseApplication
import com.dranoer.oweme.R
import com.dranoer.oweme.databinding.ActivityExpenditureBinding

class ExpenditureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpenditureBinding
    val args: ExpenditureActivityArgs by navArgs()

    private val expenditureViewModel: ExpenditureViewModel by viewModels {
        ExpenditureViewModelFactory((application as ExpenseApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExpenditureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = args.expenseTitle
        binding.fab.setOnClickListener { view ->
        }
    }
}