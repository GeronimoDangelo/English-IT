package com.study.englishit.ui.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewmodel @Inject constructor(): ViewModel() {


    private val _btnSave : MutableLiveData<Boolean> = MutableLiveData(true)
    val btnSave : LiveData<Boolean> = _btnSave

    fun saveBtn(saved: Boolean){
        viewModelScope.launch {
            _btnSave.value = saved
        }
    }

    fun getSavedBtn(){
        btnSave
    }

}