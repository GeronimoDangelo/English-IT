package com.study.englishit.ui.presentation.recovery_password

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.englishit.domain.model.User
import com.study.englishit.domain.use_cases.recovery_password.RecoverPasswordUseCase
import com.study.englishit.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecoveryPasswordViewModel @Inject constructor(
    private val recoverPasswordUseCase: RecoverPasswordUseCase,
) : ViewModel() {
    private val _recoveryPassword: MutableLiveData<DataState<Boolean>> = MutableLiveData()
    val recoveryPassword: LiveData<DataState<Boolean>> = _recoveryPassword

    fun sendRecoveryPassword(email: String) {
        viewModelScope.launch {
            recoverPasswordUseCase(email).onEach {
                _recoveryPassword.value = it
            }.launchIn(viewModelScope)
        }

    }

}