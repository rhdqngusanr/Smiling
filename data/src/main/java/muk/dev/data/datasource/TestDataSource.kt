package muk.dev.data.datasource

import muk.dev.data.model.TestModelResponse

class TestDataSource {
    fun getTestModelResponse():TestModelResponse{
        return TestModelResponse("data_response")
    }
}