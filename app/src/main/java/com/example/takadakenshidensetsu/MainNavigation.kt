package com.example.takadakenshidensetsu

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.takadakenshidensetsu.view.densetsu.DensetsuScreen
import com.example.takadakenshidensetsu.view.densetsuList.DensetsuListRoute
import com.example.takadakenshidensetsu.view.home.HomeScreen

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(modifier = modifier, navController = navController, startDestination = "home") {
        navigation(startDestination = "densetsu_home", route = "home") {
            composable(route = "densetsu_home") {
                HomeScreen(navController = navController)
            }
            composable(route = "densestu") {
                DensetsuScreen(navController = navController)
            }
        }

        composable(route = "list") {
            DensetsuListRoute()
        }
    }
}