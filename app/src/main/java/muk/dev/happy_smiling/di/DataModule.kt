package muk.dev.happy_smiling.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import muk.dev.data.repository.TempRepositoryImpl
import muk.dev.domain.repository.TempRepository

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindTempRepository(tempRepositoryImpl: TempRepositoryImpl) : TempRepository
}