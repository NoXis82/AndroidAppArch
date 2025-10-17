package ru.noxis.feature.screen.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.noxis.feature.screen.main.navigation.MainRouter
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val router: MainRouter
) : ViewModel(), MainRouter by router {

    fun addDebit() {
        router.toCreateDebit()
    }
}