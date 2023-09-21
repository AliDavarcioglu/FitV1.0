package com.example.fitv10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.fitv10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

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