package ru.noxis.androidapparch.mediator

import ru.noxis.common.enums.ReceiptType
import ru.noxis.common.navigation.api.Navigator
import ru.noxis.feature.screen.category.create.navigation.CategoryCreateDirection
import ru.noxis.feature.screen.debit.create.navigation.DebitCreateRouter
import javax.inject.Inject

class DebitCreateRouterImpl @Inject constructor(
    private val navigator: Navigator
) : DebitCreateRouter {
    override fun back() {
        navigator.navigateUp()
    }

    override fun toCreatingCategory() {
        navigator.navigate(CategoryCreateDirection.createAction(ReceiptType.Debit))
    }

    override fun toCreatingAccount() {
        println("toCreatingAccount")
    }


}