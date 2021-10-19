package com.dranoer.oweme.log

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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
                LogView()
            }
        }

        return root
    }

    @Composable
    private fun LogView() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            NotYetImplemented()
            Spacer(modifier = Modifier.height(16.dp))
            BallView()
        }
    }

    @Composable
    private fun NotYetImplemented() {
        Text(
            text = stringResource(R.string.not_yet_implemented),
            style = MaterialTheme.typography.h6,
            color = colorResource(id = R.color.light_gray),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.margin_small))
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }

    @Composable
    fun BallView() {
        val infiniteTransition = rememberInfiniteTransition()
        val animationValues = (1..3).map { index ->
            infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 12f,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = 300,
                        delayMillis = 70 * index,
                    ),
                    repeatMode = RepeatMode.Reverse,
                )
            )
        }
        Row {
            animationValues.forEach { animatedValue ->
                Ball(
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .offset(y = animatedValue.value.dp),
                )
            }
        }
    }

    @Composable
    fun Ball(
        modifier: Modifier = Modifier,
        size: Dp = 22.dp,
        backgroundColor: Color = colorResource(id = R.color.navy_dark),
    ) {
        Box(
            modifier = modifier
                .width(size)
                .height(size)
                .clipToBounds()
                .background(backgroundColor, CircleShape)
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}