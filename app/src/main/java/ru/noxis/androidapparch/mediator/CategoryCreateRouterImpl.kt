package ru.noxis.androidapparch.mediator

import ru.noxis.common.navigation.api.Navigator
import ru.noxis.feature.screen.category.create.navigation.CategoryCreateRouter
import javax.inject.Inject

class CategoryCreateRouterImpl @Inject constructor(
    private val navigator: Navigator
) : CategoryCreateRouter {

    override fun back() {
        navigator.navigateUp()
    }


}