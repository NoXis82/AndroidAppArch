package ru.noxis.feature.data.category.impl.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.noxis.androidapparch.database.AppDatabase
import ru.noxis.feature.data.category.impl.local.db.CategoryDao

@Module
@InstallIn(ViewModelComponent::class)
class CategoryDaoModule {

    @Provides
    fun provideCategoryDao(database: AppDatabase): CategoryDao = database.categoryDao()
}