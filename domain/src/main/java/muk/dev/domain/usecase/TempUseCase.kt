package muk.dev.domain.usecase

import muk.dev.domain.model.TempModel
import muk.dev.domain.repository.TempRepository
import javax.inject.Inject

class TempUseCase @Inject constructor(private val repository:TempRepository) {

    fun getTempModel( ) : TempModel{
        return repository.getTempModel()
    }
}