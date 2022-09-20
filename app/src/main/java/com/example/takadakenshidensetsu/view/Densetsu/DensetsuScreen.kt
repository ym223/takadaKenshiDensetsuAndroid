package com.example.takadakenshidensetsu.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.takadakenshidensetsu.R
import com.example.takadakenshidensetsu.view.Densetsu.DensetsuViewModel

@Composable
fun DensetsuScreen(densetsuViewModel: DensetsuViewModel = viewModel()) {

    LaunchedEffect(Unit) {
        densetsuViewModel.getDensetsu()
    }

    val densetsu = densetsuViewModel.densetsu.observeAsState()

    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally, // 横方向
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.takadakenshi),
                contentDescription = "Takada Kenshi face",
            )
            densetsu.value?.let {
                Text("$it")
            }
        }
    }
}