package ru.noxis.feature.featurecase.category.impl.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.noxis.feature.featurecase.category.api.GetDebitCategoriesFeatureCase
import ru.noxis.feature.featurecase.category.impl.GetDebitCategoriesFeatureCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface CategoryFeatureCasesModule {

    @Binds
    fun bindGetListCategoriesFeatureCase(impl: GetDebitCategoriesFeatureCaseImpl): GetDebitCategoriesFeatureCase
}