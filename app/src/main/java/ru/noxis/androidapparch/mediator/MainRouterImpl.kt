package ru.noxis.androidapparch.mediator

import ru.noxis.common.navigation.api.Navigator
import ru.noxis.feature.screen.debit.create.navigation.DebitCreateDirection
import ru.noxis.feature.screen.main.navigation.MainRouter
import ru.noxis.feature.screen.transactions.navigation.TransactionsDirection
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val navigator: Navigator
) : MainRouter{

    override fun toTransactions() {
        navigator.navigate(TransactionsDirection.createAction())
    }

    override fun toCreateDebit() {
        navigator.navigate(DebitCreateDirection.createAction())
    }

}