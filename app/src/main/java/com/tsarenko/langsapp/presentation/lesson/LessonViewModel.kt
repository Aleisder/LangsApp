package com.tsarenko.langsapp.presentation.lesson

import androidx.lifecycle.ViewModel
import com.tsarenko.langsapp.domain.usecases.lesson.GetLessonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LessonViewModel @Inject constructor(
    private val getLessonUseCase: GetLessonUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LessonState())
    val state: StateFlow<LessonState> get() = _state

    fun onEvent(event: LessonEvent) {

        when (event) {

            is LessonEvent.OpenDialog -> {
                _state.update {
                    it.copy(
                        isDialogShown = true
                    )
                }
            }

            is LessonEvent.CloseDialog -> {
                _state.update {
                    it.copy(
                        isDialogShown = false
                    )
                }
            }

        }
    }
}