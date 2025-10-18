package ru.noxis.feature.data.category.impl.local.db

import com.squareup.moshi.JsonAdapter
import ru.noxis.common.enums.ReceiptType
import ru.noxis.common.mapping.Mapper
import ru.noxis.feature.data.category.api.model.Category
import ru.noxis.feature.data.category.api.model.NewCategory
import javax.inject.Inject

class CategoryMapper @Inject constructor(
    private val adapter: JsonAdapter<Set<ReceiptType>>
) {

    val entityToDomain by lazy {
        Mapper<CategoryEntity, Category> {
            Category(
                id = it.id,
                title = it.title,
                emoji = it.emoji,
                types = adapter.fromJson(it.types)
                    ?: error("CategoryEntity.types (${it.types}) as NULL after convert from json"),
            )
        }
    }

    val domainToEntity by lazy {
        Mapper<Category, CategoryEntity> {
            CategoryEntity(
                id = it.id,
                title = it.title,
                emoji = it.emoji,
                types = adapter.toJson(it.types),
            )
        }
    }

    val newToEntity by lazy {
        Mapper<NewCategory, CategoryEntity> {
            CategoryEntity(
                id = 0,
                title = it.title,
                emoji = it.emoji,
                types = adapter.toJson(it.types),
            )
        }
    }
}
