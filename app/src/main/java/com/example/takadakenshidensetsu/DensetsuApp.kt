package com.example.takadakenshidensetsu

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.takadakenshidensetsu.ui.theme.TakadaKenshiDensetsuTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DensetsuApp(navController: NavHostController) {
    TakadaKenshiDensetsuTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "高田健志の伝説") })
            },
            bottomBar = {
                BottomNavigation(navController)
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())) {
                    MainNavHost(navController = navController)
            }
        }
    }
}
