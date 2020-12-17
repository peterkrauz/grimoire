package com.peterkrauz.grimoire.hilt

import com.peterkrauz.grimoire.data.dao.EventDao
import com.peterkrauz.grimoire.data.db.GrimoireDatabase
import com.peterkrauz.grimoire.data.repository.EventRepositoryImpl
import com.peterkrauz.grimoire.domain.entity.event.EventRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object EventModule {

    @Provides
    @Singleton
    fun provideEventRepository(dao: EventDao): EventRepository {
        return EventRepositoryImpl(dao)
    }

    @Provides
    @Singleton
    fun provideEventDao(database: GrimoireDatabase): EventDao {
        return database.eventDao()
    }
}
