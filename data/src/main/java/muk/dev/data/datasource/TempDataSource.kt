package muk.dev.data.datasource

import muk.dev.domain.model.TempModel
import javax.inject.Inject

class TempDataSource @Inject constructor() {
    //api 호출 , 내부저장소 데이터 가져오는곳
    fun getTempModel() : TempModel{
        return TempModel("test temp model")
    }
}