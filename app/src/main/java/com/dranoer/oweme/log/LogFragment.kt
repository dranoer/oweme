package com.dranoer.oweme.log

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dranoer.oweme.R
import com.dranoer.oweme.databinding.FragmentLogBinding
import com.google.accompanist.appcompattheme.AppCompatTheme

class LogFragment : Fragment() {

    private lateinit var logViewModel: LogViewModel
    private var _binding: FragmentLogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        logViewModel = ViewModelProvider(this).get(LogViewModel::class.java)

        _binding = FragmentLogBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.notYetImplemented.setContent {
            AppCompatTheme {
                NotYetImplemented()
            }
        }

        return root
    }

    @Composable
    private fun NotYetImplemented() {
        Text(
            text = stringResource(R.string.not_yet_implemented),
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.margin_small))
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}