package com.tsarenko.langsapp.presentation.registration

import android.util.Patterns.EMAIL_ADDRESS
import androidx.lifecycle.ViewModel
import com.tsarenko.langsapp.domain.usecases.registration.SignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(RegistrationState())
    val state: StateFlow<RegistrationState> get() = _state

    fun onEvent(event: RegistrationEvent) {
        when (event) {

            is RegistrationEvent.SetEmail -> {
                val isValid = EMAIL_ADDRESS.matcher(event.email).matches()
                _state.update {
                    it.copy(
                        email = event.email,
                        isEmailValid = isValid
                    )
                }
            }

            is RegistrationEvent.ChooseLanguage -> {

            }

            is RegistrationEvent.SelectInterest -> {
                _state.update {
                    // TODO: Fix chip selected visibility
                    val newList = it.interests
                    val index = it.interests.indexOf(event.interest)
                    newList[index].select()

                    val areInterestPicked = newList.any { interest -> interest.isSelected() }
                    it.copy(
                        interests = newList,
                        areInterestsPicked = areInterestPicked
                    )
                }
            }

            is RegistrationEvent.UnselectInterest -> {
                _state.update {
                    val newList = it.interests
                    val index = it.interests.indexOf(event.interest)
                    newList[index].unselect()
                    val areInterestPicked = newList.any { interest -> interest.isSelected() }
                    it.copy(
                        interests = newList,
                        areInterestsPicked =  areInterestPicked
                    )
                }
            }
        }
    }

}