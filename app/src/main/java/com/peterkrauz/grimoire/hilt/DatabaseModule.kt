package com.peterkrauz.grimoire.hilt

import android.app.Application
import androidx.room.Room
import com.peterkrauz.grimoire.data.db.GrimoireDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideGrimoireDatabase(app: Application): GrimoireDatabase {
        return Room.databaseBuilder(app, GrimoireDatabase::class.java, "grimoire")
//            .addMigrations(*MigrationHelper.getMigrations())
            .build()
    }
}
