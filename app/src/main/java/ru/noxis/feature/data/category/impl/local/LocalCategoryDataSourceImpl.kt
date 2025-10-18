package ru.noxis.feature.data.category.impl.local

import ru.noxis.feature.data.category.api.model.Category
import ru.noxis.feature.data.category.api.model.NewCategory
import ru.noxis.feature.data.category.impl.local.db.CategoryDao
import ru.noxis.feature.data.category.impl.local.db.CategoryMapper
import javax.inject.Inject
import javax.inject.Provider

class LocalCategoryDataSourceImpl @Inject constructor(
    private val daoProvider: Provider<CategoryDao>,
    private val mapper: CategoryMapper,
) : LocalCategoryDataSource {

    private val dao get() = daoProvider.get()

    override suspend fun getById(categoryId: Long): Category? =
        dao.getById(categoryId)?.let(mapper.entityToDomain)


    override suspend fun getByTitle(title: String): Category? =
        dao.getByTitle(title)?.let(mapper.entityToDomain)

    override suspend fun list(): List<Category> =
        dao.list().map(mapper.entityToDomain)

    override suspend fun save(category: NewCategory): Category? {
        val newCategoryId = dao.insert(mapper.newToEntity(category))
        return getById(newCategoryId)
    }

    override suspend fun update(category: Category) =
        dao.update(mapper.domainToEntity(category))

    override suspend fun remove(category: Category) =
        dao.delete(mapper.domainToEntity(category))

}