package muk.dev.data.model

import muk.dev.domain.model.TestModel

class TestModelResponse(val name: String?)

fun TestModelResponse.toDomainModel() : TestModel? {
    if (name!=null){
        return TestModel(name)
    }
    return null
}