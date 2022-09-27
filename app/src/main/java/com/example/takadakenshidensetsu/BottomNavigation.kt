package com.example.takadakenshidensetsu

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.takadakenshidensetsu.view.Densetsu.DensetsuScreen
import com.example.takadakenshidensetsu.view.DensetsuList.DensetsuListScreen
import com.example.takadakenshidensetsu.view.HomeScreen

sealed class Item(var dist: String, var icon: ImageVector) {
    object Home : Item("Home", Icons.Filled.Home)
    object List : Item("List", Icons.Filled.List)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigation(navController: NavHostController) {
    // 選択されたタブの管理用
    var selectedItem = remember { mutableStateOf(0) }
    // タブ
    val items = listOf(Item.Home, Item.List)

    BottomAppBar {
        // ナビゲーションバーの表示
        BottomNavigation {
            items.forEachIndexed { index, item ->
                BottomNavigationItem(
                    icon = { Icon(item.icon, contentDescription = item.dist) },
                    label = { Text(item.dist) },
                    selected = selectedItem.value == index,
                    onClick = {
                        selectedItem.value = index
                        navController.navigate(item.dist)
                    }
                )
            }
        }
    }
}

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            HomeScreen(navController = navController)
        }

        composable(route = "densestu") {
            DensetsuScreen(navController = navController)
        }

        composable(route = "list") {
            DensetsuListScreen()
        }
    }
}
