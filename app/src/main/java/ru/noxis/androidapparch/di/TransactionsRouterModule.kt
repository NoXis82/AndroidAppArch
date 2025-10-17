package ru.noxis.androidapparch.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.noxis.androidapparch.mediator.TransactionsRouterImpl
import ru.noxis.feature.screen.transactions.navigation.TransactionsRouter

@Module
@InstallIn(ViewModelComponent::class)
interface TransactionsRouterModule {
    @Binds
    fun bindTransactionsRouter(impl: TransactionsRouterImpl): TransactionsRouter
}