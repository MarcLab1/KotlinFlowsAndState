package com.kotlinflows.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Item(
    val name: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)