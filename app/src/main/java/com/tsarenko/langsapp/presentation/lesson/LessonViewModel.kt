package com.tsarenko.langsapp.presentation.lesson

import androidx.lifecycle.ViewModel
import com.tsarenko.langsapp.domain.model.LessonUnit
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

    private val firstUnit = LessonUnit.QuestionUnit(
        question = "You meet someone you know in the morning. How can you greet him?",
        answers = listOf("Guten Abend", "Guten Morgen", "Gunet Nacht", "Guten Tag"),
        correctAnswer = "Guten Morgen"
    )

    private val _state = MutableStateFlow(LessonState(currentUnit = firstUnit))
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

                is LessonEvent.ShowDropDownMenu -> {
                    _state.update {
                        it.copy(
                            isDropDownMenuShown = true
                        )
                    }
                }

                is LessonEvent.HideDropDownMenu -> {
                    _state.update {
                        it.copy(
                            isDropDownMenuShown = false
                        )
                    }
                }

                is LessonEvent.ShowReportModalSheet -> {
                    _state.update {
                        it.copy(
                            isReportBottomSheetShown = true
                        )
                    }
                }

                is LessonEvent.HideReportModalSheet -> {
                    _state.update {
                        it.copy(
                            isReportBottomSheetShown = false
                        )
                    }
                }

                is LessonEvent.SetReportDescription -> {
                    _state.update {
                        it.copy(
                            reportDescription = event.description
                        )
                    }
                }

                is LessonEvent.ShowThanksForTheReportDialog -> {
                    _state.update {
                        it.copy(
                            isThanksForTheReportDialogShown = true
                        )
                    }
                }

                is LessonEvent.HideThanksForTheReportDialog -> {
                    _state.update {
                        it.copy(
                            isThanksForTheReportDialogShown = false
                        )
                    }
                }

                is LessonEvent.SendReport -> {
                    _state.update {
                        it.copy(
                            isReportBottomSheetShown = false,
                            reportDescription = "",

                            )
                    }
                }

            }
        }
    }