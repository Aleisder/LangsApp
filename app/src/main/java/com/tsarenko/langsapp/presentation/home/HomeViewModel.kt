package com.tsarenko.langsapp.presentation.home

import androidx.lifecycle.ViewModel
import com.tsarenko.langsapp.domain.usecases.home.GetSyllabusUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSyllabusUseCase: GetSyllabusUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> get() = _state

}