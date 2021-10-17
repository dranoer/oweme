package com.dranoer.oweme.expenditure

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dranoer.oweme.R
import com.dranoer.oweme.databinding.ActivityExpenditureBinding
import com.google.android.material.snackbar.Snackbar

class ExpenditureActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpenditureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExpenditureBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}