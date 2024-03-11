package com.example.fitv10.model

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<Veri>> = userDao.readAllData()

    suspend fun addEx (veri: Veri){
        userDao.addEx(veri)
    }
    suspend fun deleteEx(veri: Veri){
        userDao.deleteEx(veri)
    }
}