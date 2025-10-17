package ru.noxis.feature.data.category.impl.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.noxis.feature.data.category.api.CategoryRepository
import ru.noxis.feature.data.category.impl.CategoryRepositoryImpl


@Module
@InstallIn(ViewModelComponent::class)
interface CategoryRepositoryModule {

    @Binds
    fun bindCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository
}