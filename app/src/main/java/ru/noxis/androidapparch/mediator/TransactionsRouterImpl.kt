package ru.noxis.androidapparch.mediator

import ru.noxis.common.navigation.api.Navigator
import ru.noxis.feature.screen.transactions.navigation.TransactionsRouter
import javax.inject.Inject

class TransactionsRouterImpl @Inject constructor(
    private val navigator: Navigator
) : TransactionsRouter {

    override fun back() {
        navigator.navigateUp()
    }
}