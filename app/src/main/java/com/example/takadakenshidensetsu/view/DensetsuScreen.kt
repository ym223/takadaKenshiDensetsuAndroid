package com.example.takadakenshidensetsu.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.takadakenshidensetsu.R

@Composable
fun DensetsuScreen() {
    Scaffold {
        Column {
            Image(
                painter = painterResource(id = R.drawable.takadakenshi),
                contentDescription = null,
            )
        }
    }
}