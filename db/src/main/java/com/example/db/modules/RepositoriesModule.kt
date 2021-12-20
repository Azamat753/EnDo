package com.example.db.modules

import com.example.db.repositories.WordsRepositories
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
interface RepositoriesModule {

    @Binds
    fun wordsRepositories(repositories: WordsRepositories)
}