package ru.noxis.androidapparch.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.noxis.androidapparch.mediator.DebitCreateRouterImpl
import ru.noxis.feature.screen.debit.create.navigation.DebitCreateRouter

@Module
@InstallIn(ViewModelComponent::class)
interface DebitCreateRouterModule {

    @Binds
    fun bindDebitCreateRouter(impl: DebitCreateRouterImpl): DebitCreateRouter

}