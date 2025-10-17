package ru.noxis.feature.screen.transactions

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.noxis.feature.screen.transactions.navigation.TransactionsRouter
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val router: TransactionsRouter
) : ViewModel(), TransactionsRouter by router