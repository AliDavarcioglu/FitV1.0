package com.example.fitv10.view

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitv10.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)





    }


//    fun firstFragment(view:View){
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//
//        val firstFragment = FirstFragment()
//        fragmentTransaction.replace(R.id.frameLayout,firstFragment).commit()
//
//    }
//    fun secondFragment(view: View){
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//
//        val secondFragment = SecondFragment()
//        fragmentTransaction.replace(R.id.frameLayout,secondFragment).commit()
//
//
//    }
}