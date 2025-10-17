package ru.noxis.feature.data.category.impl.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val emoji: String,
    val types: String,
)
