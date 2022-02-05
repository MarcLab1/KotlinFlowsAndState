package com.kotlinflows.repo

import android.content.Context
import androidx.room.Room
import com.kotlinflows.BaseApplication
import com.kotlinflows.model.Item
import com.kotlinflows.model.ItemDao
import com.kotlinflows.model.ItemDatabase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repo(val itemDao: ItemDao) {

    val itemsflow = flow<Item> {
        for (i in 1..10) {
            emit(Item(i.toString()))
            delay(300L)
        }
    }

    val itemslistflow = flow<List<Item>>
    {   var list = mutableListOf<Item>()
        for(i in 20..30 ) {
            list.add(Item(i.toString()))
            delay(150L)
        }

        emit(list)
    }

    suspend fun addItem(name: String)
    {
        itemDao.insert(Item(name))
    }

    suspend fun getItems() : Flow<List<Item>>
    {
        return itemDao.getItems()
    }

}