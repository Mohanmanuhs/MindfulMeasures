package com.example.mindfulmeasures.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.ScaleAnimation
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mindfulmeasures.SolutionActivity
import com.example.mindfulmeasures.databinding.FragmentHomeBinding
import com.example.mindfulmeasures.databinding.RvItemBinding
import com.example.mindfulmeasures.datamodel.RvModel

class RvAdapter(var dataList:ArrayList<RvModel>,var requireActivity:FragmentActivity):RecyclerView.Adapter<RvAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        anim(holder.itemView)
        holder.binding.imageView3.setImageResource(dataList[position].img)
        holder.binding.textView9.text= dataList[position].name
        holder.itemView.setOnClickListener {
            val bundle= Bundle()
            bundle.putString("value",dataList[position].value)
            bundle.putString("valu",dataList[position].valu)
            val intent=Intent(requireActivity,SolutionActivity::class.java)
            intent.putExtras(bundle)
            requireActivity.startActivity(intent)

        }
    }

    inner class MyViewHolder(var binding: RvItemBinding ):RecyclerView.ViewHolder(binding.root)


    fun anim(view:View){
        val animation= ScaleAnimation(0F, 0.0F, 0F, 0.5F)
        animation.duration=500
        view.animation=animation



    }
}