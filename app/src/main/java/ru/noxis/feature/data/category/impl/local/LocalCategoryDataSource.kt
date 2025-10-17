package ru.noxis.feature.data.category.impl.local

import ru.noxis.feature.data.category.api.model.Category
import ru.noxis.feature.data.category.api.model.NewCategory

interface LocalCategoryDataSource {

    suspend fun getById(categoryId: Long): Category?

    suspend fun getByTitle(title: String): Category?

    suspend fun list(): List<Category>

    suspend fun save(category: NewCategory): Category?

    suspend fun update(category: Category)

    suspend fun remove(category: Category)
}