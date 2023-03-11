package com.example.takadakenshidensetsu.view.DensetsuList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.takadakenshidensetsu.model.Densetsu

//後でnavigationを修正する
@Composable
fun DensetsuListRoute(
    densetsuListViewModel: DensetsuListViewModel = hiltViewModel()
) {
    DensetsuListScreen(densetsuListViewModel)
}

@Composable
fun DensetsuListScreen(
    densetsuListViewModel: DensetsuListViewModel = hiltViewModel()
) {
    //val options = listOf("全表示", "取得済みを表示")
    //val selectedOptionText = remember { mutableStateOf(options[0]) }

    val densetsuListState = densetsuListViewModel.densetsuAll.collectAsState()

    val densetsuList = densetsuListViewModel.getDensetsuAll()

    val listState = rememberLazyListState()

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {

            //DensetsuList関数にて、どう場合わけするかがわからなくなったので、一旦削除
            /*Dropdown(options = options, selectedOptionText = selectedOptionText.value) {
                selectedOptionText.value = options[it]
            }*/

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 10.dp, 0.dp),
                text = "${densetsuListState.value.size}/232",
                textAlign = TextAlign.End
            )
        }
        DensetsuList(listState = listState, densetsuList = densetsuList)
    }
}

@Composable
fun DensetsuList(
    listState: LazyListState,
    densetsuList: List<Densetsu?>
) {
    LazyColumn(state = listState) {
        items(densetsuList) { densetsu ->
            val densetsuContent = densetsu?.text ?: "？？？？？"
            DensetsuListItem(densetsuContent = densetsuContent)
        }
    }
}

//@Composable
//fun Dropdown(
//    options: List<String>,
//    selectedOptionText: String,
//    onClick: (Int) -> Unit
//) {
//    val expanded = remember { mutableStateOf(false) }
//
//    Box(
//        contentAlignment = Alignment.CenterStart,
//        modifier = Modifier
//            .padding(10.dp, 5.dp, 10.dp, 5.dp)
//            .size(160.dp, 40.dp)
//            .clip(RoundedCornerShape(4.dp))
//            .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(4.dp))
//            .clickable { expanded.value = !expanded.value },
//    ) {
//        Text(
//            text = selectedOptionText,
//            modifier = Modifier.padding(start = 10.dp)
//        )
//        Icon(
//            Icons.Filled.ArrowDropDown, "contentDescription",
//            Modifier.align(Alignment.CenterEnd)
//        )
//        DropdownMenu(
//            expanded = expanded.value,
//            onDismissRequest = { expanded.value = false }
//        ) {
//            options.forEachIndexed { id, selectionOption ->
//                DropdownMenuItem(
//                    onClick = {
//                        onClick(id)
//                        expanded.value = false
//                    }
//                ) {
//                    Text(text = selectionOption)
//                }
//            }
//        }
//    }
//}

@Composable
fun DensetsuListItem(
    densetsuContent: String,
) {
    Card(
        modifier = Modifier
            .padding(10.dp),
        RoundedCornerShape(20.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            text = densetsuContent,
            fontSize = 16.sp
        )
    }
}