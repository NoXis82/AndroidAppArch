package ru.noxis.feature.data.category.impl.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.noxis.feature.data.category.impl.local.LocalCategoryDataSource
import ru.noxis.feature.data.category.impl.local.LocalCategoryDataSourceImpl

@Module
@InstallIn(ViewModelComponent::class)
interface LocalCategoryDataSourceModule {

    @Binds
    fun bindLocalCategoryDataSource(impl: LocalCategoryDataSourceImpl): LocalCategoryDataSource
}