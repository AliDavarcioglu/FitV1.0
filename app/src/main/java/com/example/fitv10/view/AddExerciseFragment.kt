package com.example.fitv10.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fitv10.R
import com.example.fitv10.databinding.FragmentAddExerciseBinding
import com.example.fitv10.model.UserViewModel
import com.example.fitv10.model.Veri
import com.example.fitv10.viewmodel.AddExerciseViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class AddExerciseFragment : Fragment() {
    private lateinit var viewModel: AddExerciseViewModel

    val db = Firebase.firestore
    private lateinit var mUserViewModel:UserViewModel

    private var _binding: FragmentAddExerciseBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddExerciseBinding.inflate(inflater, container, false)
        val view = binding.root

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this).get(AddExerciseViewModel::class.java)

//
//        val veritabani = requireContext().openOrCreateDatabase("Exercise",Context.MODE_PRIVATE,null)
//        veritabani.execSQL("CREATE TABLE IF NOT EXISTS exercise (id INTEGER PRIMARY KEY,name VARCHAR)")

        // DELETING
//        val sqlString = "DELETE FROM exercise"
//        veritabani.execSQL(sqlString)

             binding.addExerciseButton.setOnClickListener {
                insertDataToDatabase()

//
//                var passExercise = binding.editTextText.text.toString()
//
//
//                if (passExercise!=""){
//
//                    try {
//
//                        val sqlString = "INSERT INTO exercise (name) VALUES (?)"
//                        val statement =veritabani.compileStatement(sqlString)
//                        statement.bindString(1,passExercise)
//
//                        statement.execute()
//
//
//                    }catch (e:Exception){
//                        e.printStackTrace()
//                    }
//
//
//                    val action = AddExerciseFragmentDirections.actionAddExerciseFragmentToStartFragment2(addExercise = passExercise.toString())
//                    Navigation.findNavController(it).navigate(action)
//
//                }







            }





    }
    private fun insertDataToDatabase(){
        val exerciseName = binding.editTextText.text.toString()
        //Create Veri Object
        val veri = Veri(exerciseName,0)
        //Add Data to Database
        mUserViewModel.addEx(veri)

        findNavController().navigate(R.id.action_addExerciseFragment_to_startFragment2)


    }



}