package com.example.fitv10.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fitv10.model.Veri

class AddExerciseViewModel:ViewModel() {
    val exercises = MutableLiveData<List<Veri>>()

}