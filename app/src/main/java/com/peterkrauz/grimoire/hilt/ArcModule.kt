package com.peterkrauz.grimoire.hilt

import com.peterkrauz.grimoire.data.dao.ArcDao
import com.peterkrauz.grimoire.data.repository.ArcRepositoryImpl
import com.peterkrauz.grimoire.data.db.GrimoireDatabase
import com.peterkrauz.grimoire.domain.entity.arc.ArcRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ArcModule {

    @Provides
    @Singleton
    fun provideArcRepository(dao: ArcDao): ArcRepository {
        return ArcRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideArcDao(database: GrimoireDatabase): ArcDao {
        return database.arcDao()
    }
}
