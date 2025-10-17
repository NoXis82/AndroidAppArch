package ru.noxis.feature.screen.debit.create

import ru.noxis.feature.featurecase.category.api.model.DebitCategory
import java.util.Date

data class DebitCreateState(
    val category: DebitCategory? = null,
    val description: String = "",
    val total: String = "",
    val date: Long = Date().time,
    val from: Account? = null,
    val to: Account? = null,

    val showCategorySelector: Boolean = true,
    val showDatePicker: Boolean = false,
)

data class Account(
    val title: String
)