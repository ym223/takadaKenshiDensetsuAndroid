package com.example.takadakenshidensetsu.view.DensetsuList

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.takadakenshidensetsu.model.DensetsuDatabase
import com.example.takadakenshidensetsu.repository.DensetsuRepository
import com.example.takadakenshidensetsu.view.Densetsu.DensetsuViewModel

@Composable
fun DensetsuListScreen() {
    val densetsuViewModel: DensetsuViewModel = viewModel(
        factory = DensetsuViewModel.Factory(
            DensetsuRepository(DensetsuDatabase.getInstance(LocalContext.current).densetsuDao())
        )
    )

    val densetsuListState = densetsuViewModel.densetsuList.observeAsState()

    val densetsuList = densetsuViewModel.getDensetsuAll()

    val densetsuListSize = densetsuViewModel.densetsuListSize.observeAsState()

    val listState = rememberLazyListState()

    Column {
        Text(text = "${densetsuListSize.value}/231", textAlign = TextAlign.Right)
        densetsuListState.value?.let {
            LazyColumn(state = listState) {
                items(densetsuList) { densetsu ->
                    if(densetsu != null){
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
fun ListItemNone(){
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
    }}