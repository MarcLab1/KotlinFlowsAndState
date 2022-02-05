package com.kotlinflows.ui.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.kotlinflows.model.Item
import com.kotlinflows.model.ItemDao
import com.kotlinflows.repo.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel2 @Inject constructor(
    val dao: ItemDao
) : ViewModel() {

    var itemsFlow : Flow<List<Item>>
    lateinit var itemsLiveData: LiveData<List<Item>>
    lateinit var itemsStateFlow : StateFlow<List<Item>>

    init {

        itemsFlow = dao.getItems()
        itemsLiveData = dao.getItems().asLiveData()

        viewModelScope.launch {
            itemsStateFlow = dao.getItems().stateIn(this)
        }

    }

}