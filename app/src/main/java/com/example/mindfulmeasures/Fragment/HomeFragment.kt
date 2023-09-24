package com.example.mindfulmeasures.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mindfulmeasures.R
import com.example.mindfulmeasures.adapter.RvAdapter
import com.example.mindfulmeasures.databinding.FragmentHomeBinding
import com.example.mindfulmeasures.datamodel.RvModel


class HomeFragment : Fragment() {
    private val binding: FragmentHomeBinding by lazy{
       FragmentHomeBinding.inflate(layoutInflater)
    }
    private var arr=ArrayList<RvModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arr.clear()
        arr.add(RvModel(R.drawable.mentalhealth,"Mental Health","mental health","ment"))
        arr.add(RvModel(R.drawable.social,"Social Media\n   Pressure","socialmediapressure","soc"))
        arr.add(RvModel(R.drawable.harrasement,"    Online \nHarassment","harassment","harrs"))
        arr.add(RvModel(R.drawable.info_overload,"Information\n  overload","infooverload","info"))

        binding.rv.layoutManager=GridLayoutManager(requireContext(),2)
        var adapter=RvAdapter(arr,requireActivity())
        binding.rv.adapter=adapter
        binding.rv.setHasFixedSize(true)

    }

    companion object {

    }
}