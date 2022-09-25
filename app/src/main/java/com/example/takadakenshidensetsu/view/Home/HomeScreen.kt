package com.example.takadakenshidensetsu.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, // 横方向
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "高田健志伝説")
        Button(onClick = { navController.navigate("densestu") }) {
            Text(text = "伝説を探す")
        }
    }
}