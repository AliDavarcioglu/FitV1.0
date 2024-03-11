package com.example.fitv10.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application:Application):AndroidViewModel(application) {
    val readAllData : LiveData<List<Veri>>
    private val repository:UserRepository


    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }
    fun addEx(veri: Veri){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEx(veri)
        }
    }
    fun deleteEx(veri: Veri){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteEx(veri)
        }
    }
}