package com.study.englishit.ui.presentation.sign_up

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.englishit.domain.model.User
import com.study.englishit.domain.use_cases.signup.SignUpUseCase
import com.study.englishit.domain.use_cases.signup.SaveUserUseCase
import com.study.englishit.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

    private val signUpUseCase: SignUpUseCase,
    private val saveUserUseCase: SaveUserUseCase,

) : ViewModel() {

    private val _signUpState: MutableLiveData<Result<User>> = MutableLiveData()
    val signUpState: LiveData<Result<User>> = _signUpState

    private val _saveUserState: MutableLiveData<Result<Boolean>> = MutableLiveData()
    val saveUserState: LiveData<Result<Boolean>> = _saveUserState


    fun signUp(user: User, password: String) {
        viewModelScope.launch {
            signUpUseCase(user, password)
                .onEach { dataState ->
                    _signUpState.value = dataState
                }.launchIn(viewModelScope)
        }
    }

    fun saveUser(user: User) {
        viewModelScope.launch {
            saveUserUseCase(user)
                .onEach { dataState ->
                    _saveUserState.value = dataState
                }.launchIn(viewModelScope)
        }
    }
}