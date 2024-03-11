package com.example.fitv10.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table")
data class Veri (
    @PrimaryKey
        //(autoGenerate = true)
     val exName:String,
     val id:Long
){

}