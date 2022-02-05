package com.kotlinflows.ui.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kotlinflows.model.Item
import kotlinx.coroutines.flow.collectLatest

@Composable
fun Flows2(vm2: MyViewModel2) {


    var itemsFlow = vm2.itemsFlow.collectAsState(initial = listOf())
    var itemsLiveData = vm2.itemsLiveData.observeAsState()
    var itemsStateFlow = vm2.itemsStateFlow

    LazyColumn()
    {
        items(itemsFlow.value)
        {
            ItemCard(item = it)
        }
        item()
        {
            Divider()
        }
        items(itemsStateFlow.value)
        {
            ItemCard(item = it)
        }

    }
}

@Composable
fun ItemCard(item: Item) {
    Text(text = item.toString())
}
