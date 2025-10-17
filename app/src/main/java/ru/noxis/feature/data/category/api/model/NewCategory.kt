package ru.noxis.feature.data.category.api.model

import ru.noxis.common.enums.ReceiptType

data class NewCategory(
    val title: String,
    val emoji: String,
    val types: Set<ReceiptType>,
)
