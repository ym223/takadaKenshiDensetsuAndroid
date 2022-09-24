package com.example.takadakenshidensetsu.view.DensetsuList

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.takadakenshidensetsu.view.Densetsu.DensetsuViewModel

@Composable
fun DensetsuListScreen(){
    val densetsuViewModel = viewModel(modelClass = DensetsuViewModel::class.java)
    

}