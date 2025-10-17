package ru.noxis.feature.featurecase.category.impl

import ru.noxis.common.enums.ReceiptType
import ru.noxis.feature.data.category.api.CategoryRepository
import ru.noxis.feature.featurecase.category.api.GetDebitCategoriesFeatureCase
import ru.noxis.feature.featurecase.category.api.model.DebitCategory
import javax.inject.Inject

class GetDebitCategoriesFeatureCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository,
) : GetDebitCategoriesFeatureCase {

    override suspend fun invoke(): List<DebitCategory> = categoryRepository.list()
        .filter { it.types.contains(ReceiptType.Debit) }
        .map { DebitCategory(it.id, it.title, it.emoji) }
}