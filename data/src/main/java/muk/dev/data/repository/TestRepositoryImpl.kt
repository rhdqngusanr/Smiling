package muk.dev.data.repository

import muk.dev.data.datasource.TestDataSource
import muk.dev.data.model.toDomainModel
import muk.dev.domain.model.TestModel
import muk.dev.domain.repository.TestRepository

class TestRepositoryImpl(val dataSource: TestDataSource):TestRepository {
    override fun getTestData(): TestModel? {
        return dataSource.getTestModelResponse().toDomainModel()
    }

}