package ru.noxis.feature.screen.debit.create.navigation

import ru.noxis.common.navigation.api.Direction

object DebitCreateDirection : Direction("debit/create") {

    fun createAction() = createNavAction()
}