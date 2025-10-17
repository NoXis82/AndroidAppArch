package ru.noxis.androidapparch.mediator

import ru.noxis.common.navigation.api.Navigator
import ru.noxis.feature.screen.debit.create.navigation.DebitCreateRouter
import javax.inject.Inject

class DebitCreateRouterImpl @Inject constructor(
    private val navigator: Navigator
) : DebitCreateRouter {
    override fun back() {
        navigator.navigateUp()
    }

    override fun toCreatingCategory() {
        println("toCreatingCategory")
    }

    override fun toCreatingAccount() {
        println("toCreatingAccount")
    }


}