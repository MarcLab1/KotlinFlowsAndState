package com.kotlinflows.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlinflows.model.Item
import com.kotlinflows.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel3 @Inject constructor(
    val repo: Repo
) : ViewModel() {

    var flowItems: Flow<List<Item>>? = null

    init {
        getItems()
    }

    fun getItems() {
        viewModelScope.launch {
            flowItems = repo.getItems()
        }
    }

    fun addItem(name: String) {
        viewModelScope.launch {
            repo.addItem(name)
        }
    }

    fun filterItems() {
        if (flowItems != null) {

            flowItems = flowItems?.map {
                it.filter { item ->
                    item.id % 2 == 0
                }
            }
        }
    }

}