package ru.noxis.androidapparch.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.noxis.feature.data.category.impl.local.db.CategoryDatabase
import ru.noxis.feature.data.category.impl.local.db.CategoryEntity

@Database(
    entities = [
        CategoryEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase(), CategoryDatabase {

    companion object {
        const val DB_NAME = "AppDatabase"
    }
}

