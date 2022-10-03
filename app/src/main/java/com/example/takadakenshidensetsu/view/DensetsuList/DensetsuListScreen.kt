package com.example.takadakenshidensetsu.view.DensetsuList

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.takadakenshidensetsu.model.DensetsuDatabase
import com.example.takadakenshidensetsu.model.DensetsuResult
import com.example.takadakenshidensetsu.repository.DensetsuRepository
import com.example.takadakenshidensetsu.view.Densetsu.DensetsuViewModel

@Composable
fun DensetsuListScreen() {
    val densetsuViewModel: DensetsuViewModel = viewModel(
        factory = DensetsuViewModel.Factory(
            DensetsuRepository(DensetsuDatabase.getInstance(LocalContext.current).densetsuDao())
        )
    )

    val densetsuListState = densetsuViewModel.densetsuAll.observeAsState()

    val densetsuList = densetsuViewModel.getDensetsuAll()

    val listState = rememberLazyListState()

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Dropdown(densetsuViewModel = densetsuViewModel)
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 10.dp, 0.dp),
                text = "${densetsuListState.value?.size}/231",
                textAlign = TextAlign.End
            )
        }
        densetsuListState.value?.let {
            LazyColumn(state = listState) {
                items(densetsuList) { densetsu ->
                    if (densetsu != null) {
                        DensetsuListItem(densetsu.text)
                    } else {
                        ListItemNone()
                    }
                }
            }
        }
    }
}

@Composable
fun Dropdown(
    densetsuViewModel: DensetsuViewModel
) {
    val options = listOf("全表示", "取得済みを表示")
    val expanded = remember { mutableStateOf(false) }
    val selectedOptionText = remember { mutableStateOf(options[0]) }

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .padding(10.dp, 5.dp, 10.dp, 5.dp)
            .size(160.dp, 40.dp)
            .clip(RoundedCornerShape(4.dp))
            .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(4.dp))
            .clickable { expanded.value = !expanded.value },
    ) {
        Text(
            text = selectedOptionText.value,
            modifier = Modifier.padding(start = 10.dp)
        )
        Icon(
            Icons.Filled.ArrowDropDown, "contentDescription",
            Modifier.align(Alignment.CenterEnd)
        )
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        selectedOptionText.value = selectionOption
                        expanded.value = false
                    }
                ) {
                    Text(text = selectionOption)
                }
            }
        }
    }
}

@Composable
fun DensetsuListItem(
    densetsuContent: String,
) {
    Card(
        modifier = Modifier
            .padding(10.dp, 10.dp),
        RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp, 10.dp)
        ) {
            Text(text = densetsuContent, fontSize = 16.sp)
        }
    }
}

@Composable
fun ListItemNone() {
    Card(
        modifier = Modifier
            .padding(10.dp, 10.dp),
        RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp, 10.dp)
        ) {
            Text(text = "？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？", fontSize = 16.sp, maxLines = 1)
        }
    }
}