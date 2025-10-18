package ru.noxis.feature.screen.category.create

import ru.noxis.common.enums.ReceiptType

data class NewCategoryModel(
    val title: String,
    val emoji: String,
    val types: Set<ReceiptType>,
)
