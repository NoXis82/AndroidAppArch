package ru.noxis.feature.featurecase.category.impl

import ru.noxis.common.enums.ReceiptType
import ru.noxis.feature.data.category.api.CategoryRepository
import ru.noxis.feature.data.category.api.model.NewCategory
import ru.noxis.feature.featurecase.category.api.SaveNewCategoryFeatureCase
import ru.noxis.feature.featurecase.category.api.SaveNewCategoryResult
import javax.inject.Inject

class SaveNewCategoryFeatureCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository,
) : SaveNewCategoryFeatureCase {

    override suspend fun invoke(title: String, emoji: String, types: Set<ReceiptType>): SaveNewCategoryResult {
        if (title.isEmpty()) return SaveNewCategoryResult.EmptyTitle
        if (types.isEmpty()) return SaveNewCategoryResult.EmptyTypes

        val isAlreadyExist = categoryRepository.getByTitle(title) != null
        if (isAlreadyExist) return SaveNewCategoryResult.IsAlreadyExist

        val savedCategory = categoryRepository.save(NewCategory(title, emoji, types))
        return if (savedCategory != null) SaveNewCategoryResult.Success else SaveNewCategoryResult.FailOnSave
    }
}