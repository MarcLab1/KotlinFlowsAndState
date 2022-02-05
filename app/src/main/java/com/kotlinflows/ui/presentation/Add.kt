package com.kotlinflows.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController

@Composable
fun Add(vm: MyViewModel3, nav: NavController) {
    var name = remember { mutableStateOf("") }

    Column() {
        TextField(value = name.value, onValueChange = { name.value = it })

        Button(onClick = {
            vm.addItem(name.value)
            nav.navigate("third") })
            {
                Text("Add this thang")
            }
        }
    }