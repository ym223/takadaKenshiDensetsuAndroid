package com.example.takadakenshidensetsu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.takadakenshidensetsu.ui.theme.TakadaKenshiDensetsuTheme

@Composable
fun DensetsuApp(navController: NavHostController) {
    TakadaKenshiDensetsuTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "高田健志の伝説") })
            },
            bottomBar = {
                MainNavigationBar(navController)
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())) {
                    MainNavigation(navController = navController)
            }
        }
    }
}
