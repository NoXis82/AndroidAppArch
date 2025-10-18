package ru.noxis.feature.screen.category.create.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import ru.noxis.common.enums.ReceiptType
import ru.noxis.common.navigation.api.Direction

private const val KEY_RECEIPT_TYPE = "receiptType"

object CategoryCreateDirection : Direction("category/create") {

    override val route: String
        get() = "$target/{$KEY_RECEIPT_TYPE}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(navArgument(KEY_RECEIPT_TYPE) { type = NavType.StringType })

    fun createAction(receiptType: ReceiptType) = createNavAction("$target/${receiptType.name}")

    fun getReceiptType(savedStateHandle: SavedStateHandle): ReceiptType? =
        savedStateHandle.get<String>(KEY_RECEIPT_TYPE)?.let(ReceiptType::valueOf)
}
