package com.example.takadakenshidensetsu.view.Densetsu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.takadakenshidensetsu.R

@Composable
fun DensetsuScreen(navController: NavController, densetsuViewModel: DensetsuViewModel = viewModel()) {

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
                modifier = Modifier.padding(80.dp, 10.dp)
            )
            densetsu.value?.let { densetsu ->
                Text(densetsu, Modifier.padding(10.dp, 10.dp))
            }
            Button(onClick = { navController.navigate("home") }) {
                Text(text = "もう一度伝説を探す")
            }
        }
    }
}