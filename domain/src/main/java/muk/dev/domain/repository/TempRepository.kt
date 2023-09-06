package muk.dev.domain.repository

import muk.dev.domain.model.TempModel

interface TempRepository {
    fun getTempModel() : TempModel
}