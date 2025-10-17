package ru.noxis.feature.screen.transactions.navigation

import ru.noxis.common.navigation.api.Direction

object TransactionsDirection: Direction("transactions") {

    fun createAction() = createNavAction()
}