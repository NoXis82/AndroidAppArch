package ru.noxis.androidapparch.mediator.graph

import androidx.navigation.NavGraphBuilder
import ru.noxis.feature.screen.debit.create.composableToDebitCreate
import ru.noxis.feature.screen.main.composableToMain
import ru.noxis.feature.screen.transactions.composableToTransactions

fun NavGraphBuilder.composableAll() {
    composableToMain()
    composableToTransactions()
    composableToDebitCreate()
//    composableToCategoryCreate()
//    composableToAccountCreate()
}