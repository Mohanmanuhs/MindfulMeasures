package com.example.mindfulmeasures.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.ScaleAnimation
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mindfulmeasures.Solutions
import com.example.mindfulmeasures.databinding.SolrvItemBinding
import com.example.mindfulmeasures.datamodel.SolRvModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class SolRvAdapter(var dataList:ArrayList<SolRvModel>, var requireActivity: FragmentActivity):
    RecyclerView.Adapter<SolRvAdapter.MyViewHolder>() {
    private val db = Firebase.firestore

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding= SolrvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        anim(holder.itemView)
        Picasso.get().load(dataList[position].img).into(holder.binding.imageView3)
        holder.binding.textView9.text= dataList[position].name
        holder.itemView.setOnClickListener {
            val intent= Intent(requireActivity, Solutions::class.java)
            intent.putExtra("name",dataList[position].name)
            requireActivity.startActivity(intent)

        }
    }

    inner class MyViewHolder(var binding: SolrvItemBinding): RecyclerView.ViewHolder(binding.root)


    private fun anim(view: View){
        val animation= ScaleAnimation(0F, 0.0F, 0F, 0.5F)
        animation.duration=500
        view.animation=animation

    }
}