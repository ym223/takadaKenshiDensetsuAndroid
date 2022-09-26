package com.example.takadakenshidensetsu.view.DensetsuList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.takadakenshidensetsu.model.DensetsuDatabase
import com.example.takadakenshidensetsu.model.DensetsuResult
import com.example.takadakenshidensetsu.repository.DensetsuRepository
import com.example.takadakenshidensetsu.view.Densetsu.DensetsuViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun DensetsuListScreen() {
    val densetsuViewModel: DensetsuViewModel = viewModel(
        factory = DensetsuViewModel.Factory(
            DensetsuRepository(DensetsuDatabase.getInstance(LocalContext.current).densetsuDao())
        )
    )

    val densetsuList = densetsuViewModel.densetsuList.observeAsState()

    densetsuViewModel.getDensetsuAll()

    val listState = rememberLazyListState()

    densetsuList.value?.let { densetsuList ->
        LazyColumn(state = listState) {
            items(densetsuList) { densetsu ->
                DensetsuListItem(densetsu)
            }
        }
    }
}

@Composable
fun DensetsuListItem(
    densetsu: DensetsuResult,
) {
    Column(
        modifier = Modifier
            .padding(10.dp, 10.dp)
    ) {
        Text(text = densetsu.text)
    }
    Divider()
}