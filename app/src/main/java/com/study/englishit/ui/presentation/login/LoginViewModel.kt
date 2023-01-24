package com.study.englishit.ui.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.englishit.domain.use_cases.login.GetUserDataUseCase
import com.study.englishit.domain.use_cases.logout.LogOutUseCase
import com.study.englishit.domain.use_cases.login.LoginUseCase
import com.study.englishit.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val logOutUseCase: LogOutUseCase,
    private val getUserDataUseCase: GetUserDataUseCase,
) : ViewModel() {

    private val _loginState: MutableStateFlow<Result<Boolean>> = MutableStateFlow(Result.Empty)
    val loginState: StateFlow<Result<Boolean>> = _loginState.asStateFlow()


    private val _logOut: MutableStateFlow<Result<Boolean>> = MutableStateFlow(Result.Empty)
    val logOut: StateFlow<Result<Boolean>> = _logOut.asStateFlow()

    private val _userResult: MutableStateFlow<Result<Boolean>> = MutableStateFlow(Result.Empty)
    val userResult: StateFlow<Result<Boolean>> = _userResult.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginUseCase(email = email, password = password).onEach { dataState ->
                _loginState.value = dataState
            }.launchIn(viewModelScope)
        }
    }

    fun logOut() {
        viewModelScope.launch {
            logOutUseCase().onEach { dataState ->
                _logOut.value = dataState
            }.launchIn(viewModelScope)
        }
    }

    fun getUserData() {
        viewModelScope.launch {
            getUserDataUseCase().onEach { dataState ->
                _userResult.value = dataState
            }.launchIn(viewModelScope)
        }
    }
}