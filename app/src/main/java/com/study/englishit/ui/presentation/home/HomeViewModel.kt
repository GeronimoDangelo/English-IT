package com.study.englishit.ui.presentation.home

import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.study.englishit.di.FirebaseModule
import com.study.englishit.domain.model.User
import com.study.englishit.util.Constants
import com.study.englishit.util.Constants.USER_POINTS_GET
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val firebaseAuth: FirebaseAuth,
    @FirebaseModule.UsersCollection private var usersCollection: CollectionReference,
) : ViewModel() {


    private val _totalPoints: MutableLiveData<Int> = MutableLiveData(0)
    var totalPoints: LiveData<Int> = _totalPoints

    fun lessonCompleted() {
        viewModelScope.launch {
            _totalPoints.value = _totalPoints.value?.plus(5)
        }
    }

    fun getPoints() {
        viewModelScope.launch {
            _totalPoints.value = sharedPreferences.getInt("count", 0)
            try {
                firebaseAuth.currentUser?.uid?.let {
                    usersCollection.document(it)
                        .get()
                        .addOnSuccessListener {
                            val user = it.toObject(User::class.java)!!
                            USER_POINTS_GET = user.points.toString()
                            _totalPoints.value = USER_POINTS_GET.toInt()
                            sharedPreferences.edit().putInt("count", USER_POINTS_GET.toInt()).apply()
                        }
                        .addOnFailureListener {
                            Log.e("getting data form firebase", it.toString())
                            _totalPoints.value = 23
                        }
                }
            } catch (e: Exception) {
                Log.e("points failed recovery", e.toString())
            }

        }
    }


}