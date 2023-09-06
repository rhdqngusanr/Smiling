package muk.dev.data.repository

import muk.dev.data.datasource.TempDataSource
import muk.dev.domain.model.TempModel
import muk.dev.domain.repository.TempRepository
import javax.inject.Inject

class TempRepositoryImpl @Inject constructor(private val dataSource: TempDataSource): TempRepository {
    override fun getTempModel(): TempModel {
        return dataSource.getTempModel()
    }

}