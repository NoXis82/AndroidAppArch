package ru.noxis.androidapparch.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.noxis.androidapparch.mediator.CategoryCreateRouterImpl
import ru.noxis.feature.screen.category.create.navigation.CategoryCreateRouter


@Module
@InstallIn(ViewModelComponent::class)
interface CategoryCreateRouterModule {

    @Binds
    fun bindCategoryCreateRouter(impl: CategoryCreateRouterImpl): CategoryCreateRouter
}