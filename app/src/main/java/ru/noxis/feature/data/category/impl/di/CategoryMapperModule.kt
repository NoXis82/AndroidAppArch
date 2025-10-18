@file:OptIn(ExperimentalStdlibApi::class)

package ru.noxis.feature.data.category.impl.di

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.noxis.common.enums.ReceiptType
import ru.noxis.feature.data.category.impl.local.db.CategoryMapper

@Module
@InstallIn(ViewModelComponent::class)
class CategoryMapperModule {
    @Provides
    fun provideCategoryMapper(adapter: JsonAdapter<Set<ReceiptType>>): CategoryMapper =
        CategoryMapper(adapter)

    @Provides
    fun provideJsonAdapterForSetReceiptType(moshi: Moshi): JsonAdapter<Set<ReceiptType>> =
        moshi.adapter()
}