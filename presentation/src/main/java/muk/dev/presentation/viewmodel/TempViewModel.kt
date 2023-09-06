package muk.dev.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import muk.dev.domain.model.TempModel
import muk.dev.domain.usecase.TempUseCase
import javax.inject.Inject

@HiltViewModel
class TempViewModel @Inject constructor(private val useCase : TempUseCase) :ViewModel() {
    fun getTempModel() : TempModel{
        return useCase.getTempModel()

    }
}