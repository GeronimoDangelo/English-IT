package com.study.englishit.ui.presentation.home

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val sharedPreferences: SharedPreferences) :
    ViewModel() {


    private val _totalPoints: MutableLiveData<Int> = MutableLiveData(0)
    var totalPoints: LiveData<Int> = _totalPoints

    fun lessonCompleted() {
        viewModelScope.launch {
            _totalPoints.value = _totalPoints.value?.plus(5)
        }
    }

    fun getPoints() {
        viewModelScope.launch {
            _totalPoints.value = sharedPreferences.getInt("count",0)
        }
    }




}