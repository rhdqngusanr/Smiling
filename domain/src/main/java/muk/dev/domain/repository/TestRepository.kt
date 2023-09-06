package muk.dev.domain.repository

import muk.dev.domain.model.TestModel

interface TestRepository {
    fun getTestData() : TestModel?
}