package com.kotlinflows.ui.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Flows1() {
    var vm: MyViewModel = viewModel()
    var numbers1 = vm.numbers1
    var items1 = vm.items1

    Row(modifier = Modifier.fillMaxWidth())
    {
        Column(modifier = Modifier.fillMaxWidth(.3f))
        {
            Text(numbers1.size.toString())

        }
        Column(modifier = Modifier.fillMaxWidth(.5f))
        {   Text("for each")
            numbers1.forEach { number ->
                Text(number.toString())
            }
        }
        Column(modifier = Modifier.fillMaxWidth())
        {   Text("map")
            items1.map { item ->
                Text(item.toString())
            }
        }
    }
}

