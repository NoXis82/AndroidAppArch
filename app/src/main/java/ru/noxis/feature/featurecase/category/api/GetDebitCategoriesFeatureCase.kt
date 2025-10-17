package ru.noxis.feature.featurecase.category.api

import ru.noxis.feature.featurecase.category.api.model.DebitCategory

interface GetDebitCategoriesFeatureCase {

    suspend operator fun invoke(): List<DebitCategory>
}