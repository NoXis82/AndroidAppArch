package ru.noxis.androidapparch.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.noxis.androidapparch.mediator.MainRouterImpl
import ru.noxis.feature.screen.main.navigation.MainRouter

@Module
@InstallIn(ViewModelComponent::class)
interface MainRouterModule {

    @Binds
    fun bindMainRouter(impl: MainRouterImpl): MainRouter
}