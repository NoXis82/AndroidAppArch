package ru.noxis.feature.screen.main.navigation

import ru.noxis.common.navigation.api.Direction

object MainDirection: Direction("main") {

    fun creationAction() = createNavAction()
}