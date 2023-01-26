package com.study.englishit.ui.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.englishit.domain.use_cases.login.GetUserDataUseCase
import com.study.englishit.domain.use_cases.logout.LogOutUseCase
import com.study.englishit.domain.use_cases.login.LoginUseCase
import com.study.englishit.util.DataState
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

    private val _loginState: MutableLiveData<DataState<Boolean>> = MutableLiveData()
    val loginState: LiveData<DataState<Boolean>> = _loginState


    private val _logOut: MutableLiveData<DataState<Boolean>> = MutableLiveData()
    val logOutState: LiveData<DataState<Boolean>> = _logOut

    private val _userDataState: MutableLiveData<DataState<Boolean>> = MutableLiveData()
    val userDataState: LiveData<DataState<Boolean>> = _userDataState

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
                _userDataState.value = dataState
            }.launchIn(viewModelScope)
        }
    }
}