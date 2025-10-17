package ru.noxis.feature.data.category.api

import ru.noxis.feature.data.category.api.model.Category
import ru.noxis.feature.data.category.api.model.NewCategory

interface CategoryRepository {

    suspend fun getById(categoryId: Long): Category?

    suspend fun getByTitle(title: String): Category?

    suspend fun list(): List<Category>

    suspend fun save(newCategory: NewCategory): Category?

    suspend fun save(category: Category)

    suspend fun remove(category: Category)
}