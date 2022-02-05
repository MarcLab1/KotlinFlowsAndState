package com.kotlinflows.ui.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.res.stringArrayResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlinflows.model.Item
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    //flow{} - is a builder
    //emit(value) - sends a value
    //collect{} - receives the values
    //use collectAsState{} instead of collect{} in a @Composable

    var numbers1 = mutableStateListOf<Int>()
    var items1 = mutableStateListOf<Item>()

    var flowInt = flow<Int> {
        for (i in 1..10) {
            emit(i)
            delay(300L)
        }
    }

    var flowTodo = flow<Item>
    {
        for (i in 1..3) {
            emit(Item(i.toString()))
        }
    }


    init {
        viewModelScope.launch {
            flowInt.collect { i ->
                println(i.toString())
                numbers1.add(i)
            }

            flowTodo.collect { it ->
                println(it.toString())
                items1.add(it)
            }
        }
    }
}