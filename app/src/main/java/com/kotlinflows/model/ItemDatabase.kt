package com.kotlinflows.model

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.withContext

@Database(
    entities = [Item::class],
    version = 1
)
abstract class ItemDatabase : RoomDatabase() {

    abstract val itemDao : ItemDao

}