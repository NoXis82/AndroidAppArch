package ru.noxis.feature.data.category.impl.local

import ru.noxis.feature.data.category.api.model.Category
import ru.noxis.feature.data.category.api.model.NewCategory
import ru.noxis.feature.data.category.impl.local.db.CategoryDao
import javax.inject.Inject
import javax.inject.Provider

class LocalCategoryDataSourceImpl @Inject constructor(
    private val daoProvider: Provider<CategoryDao>,
): LocalCategoryDataSource {

    private val dao get() = daoProvider.get()

    override suspend fun getById(categoryId: Long): Category? {
        TODO("Not yet implemented")
    }

    override suspend fun getByTitle(title: String): Category? {
        TODO("Not yet implemented")
    }

    override suspend fun list(): List<Category> {
        TODO("Not yet implemented")
    }

    override suspend fun save(category: NewCategory): Category? {
        TODO("Not yet implemented")
    }

    override suspend fun update(category: Category) {
        TODO("Not yet implemented")
    }

    override suspend fun remove(category: Category) {
        TODO("Not yet implemented")
    }

}