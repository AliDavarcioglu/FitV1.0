package com.example.fitv10.view

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitv10.databinding.FragmentStartBinding
import com.example.fitv10.model.UserViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    //FragmentSecondBinding hangı fragmentte olduğuna göre değişir.

    val db = Firebase.firestore
    private lateinit var mUserViewModel: UserViewModel




    val liste = ArrayList<String>()
    var addEx = "null"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)





    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        val view = binding.root



        return view




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        liste.clear()






//        val layoutManager = LinearLayoutManager(context)
//        binding.recyclerView.layoutManager = layoutManager
//        val adapter = RecyclerAdapter(liste)
//        binding.recyclerView.adapter=adapter

        val adapter = RecyclerAdapter(liste)
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //UserViewModel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {veri->
            adapter.setData(veri)

        })









        arguments?.let {
               addEx = StartFragmentArgs.fromBundle(it).addExercise!!
            }


//        try {
//
//            val veritabani = requireContext().openOrCreateDatabase("Exercise",Context.MODE_PRIVATE,null)
//
//            val cursor = veritabani.rawQuery("SELECT * FROM exercise",null)
//
//            val idColumnIndex = cursor.getColumnIndex("id")
//            val nameColumnIndex = cursor.getColumnIndex("name")
//
//            while (cursor.moveToNext()){
//                liste.add(cursor.getString(nameColumnIndex))
//                println(cursor.getInt(idColumnIndex))
//                println(cursor.getString(nameColumnIndex))
//            }
//            cursor.close()
//
//
//        }catch (e:Exception){
//
//
//        }
//
//



        adapter.notifyDataSetChanged()



        binding.button.setOnClickListener {
            val action = StartFragmentDirections.actionStartFragmentToAddExerciseFragment()
            Navigation.findNavController(it).navigate(action)

        }



    }

}