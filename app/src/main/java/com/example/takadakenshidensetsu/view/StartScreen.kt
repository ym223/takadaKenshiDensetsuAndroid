package com.example.takadakenshidensetsu.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StartScreen(navController: NavController){
    Scaffold {
        Column {
            Text(text = "高田健志伝説")
            Button(onClick = { navController.navigate("densestu") }) {
                Text(text = "伝説を探す")
            }
        }
    }
}