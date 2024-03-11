package com.example.fitv10.view

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fitv10.R
import com.example.fitv10.model.UserViewModel
import com.example.fitv10.model.Veri
import com.example.fitv10.viewmodel.AddExerciseViewModel



class RecyclerAdapter (val liste : ArrayList<String>):RecyclerView.Adapter<RecyclerAdapter.ExerciseVH>() {

    private var exList = emptyList<Veri>()
    private lateinit var mUserViewModel: UserViewModel
    private lateinit var viewModel: AddExerciseViewModel


    class ExerciseVH(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return  ExerciseVH(itemView)

    }

    override fun getItemCount(): Int {
        return  exList.size

    }

    override fun onBindViewHolder(holder: ExerciseVH, position: Int) {


        val currentItem = exList[position]
        holder.itemView.findViewById<TextView>(R.id.recyclerTextView).text = currentItem.exName



      //// SOLVE
        mUserViewModel = ViewModelProvider(holder.itemView.context as ViewModelStoreOwner).get(UserViewModel::class.java)
        viewModel = ViewModelProvider(holder.itemView.context as ViewModelStoreOwner).get(AddExerciseViewModel::class.java)






        holder.itemView.setOnClickListener {
            val action = StartFragmentDirections.actionStartFragmentToExerciseFragment(currentItem.exName.toString())
            Navigation.findNavController(it).navigate(action)
            
        }




        holder.itemView.setOnLongClickListener {



                val builder = AlertDialog.Builder(holder.itemView.context)
                val dialogView: View = LayoutInflater.from(holder.itemView.context).inflate(R.layout.confirmation_dialog, null)

                builder.setView(dialogView)
                val dialog = builder.create()

                val btnConfirm: Button = dialogView.findViewById(R.id.btnConfirm)
                val btnCancel: Button = dialogView.findViewById(R.id.btnCancel)

                btnConfirm.setOnClickListener {

                    //val veri = Veri(currentItem.exName,currentItem.id)

                    mUserViewModel.deleteEx(currentItem)
                    dialog.dismiss()
                }

                btnCancel.setOnClickListener {
                    // Hayır düğmesine tıklanınca yapılacak işlem
                    dialog.dismiss()
                }

                dialog.show()

             true

        }

    }
    fun setData(veri: List<Veri>){
        this.exList=veri
        notifyDataSetChanged()

    }

}

