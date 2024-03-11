package com.example.fitv10.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEx(veri: Veri)

    @Delete
    suspend fun deleteEx(veri: Veri)


    @Query("SELECT * FROM 'table' ORDER BY id ASC")
    fun readAllData():LiveData<List<Veri>>




}