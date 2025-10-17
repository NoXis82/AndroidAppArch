package ru.noxis.androidapparch.mediator

import ru.noxis.common.navigation.api.Navigator
import ru.noxis.feature.screen.main.navigation.MainRouter
import javax.inject.Inject

class MainRouterImpl @Inject constructor(
    private val navigator: Navigator
) : MainRouter{

    override fun toTransactions() {
        TODO("Not yet implemented")
    }

    override fun toCreateDebit() {
        TODO("Not yet implemented")
    }

}