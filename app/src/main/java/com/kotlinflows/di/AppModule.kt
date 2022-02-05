package com.kotlinflows.di

import android.app.Application
import androidx.room.Room
import com.kotlinflows.model.ItemDao
import com.kotlinflows.model.ItemDatabase
import com.kotlinflows.repo.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRepo(itemDatabase: ItemDatabase) : Repo
    {
        return Repo(itemDatabase.itemDao)
    }

    @Singleton
    @Provides
    fun provideItemDatabase(app: Application) : ItemDatabase
    {
        return Room.databaseBuilder(app, ItemDatabase::class.java, "item").build()
    }

    @Singleton
    @Provides
    fun provideItemDao(db: ItemDatabase) : ItemDao
    {
        return db.itemDao
    }

}