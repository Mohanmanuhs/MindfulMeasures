package com.example.mindfulmeasures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mindfulmeasures.adapter.SolRvAdapter
import com.example.mindfulmeasures.databinding.ActivitySolutionBinding
import com.example.mindfulmeasures.datamodel.SolRvModel
import com.example.mindfulmeasures.datamodel.Userdata
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SolutionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySolutionBinding
    private val db = FirebaseFirestore.getInstance()
    private var dataList = ArrayList<SolRvModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySolutionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var text = intent.getStringExtra("name")
        binding.textView7.text = text
        var SolrvAdapter = SolRvAdapter(dataList, this)
        binding.solRv.layoutManager = LinearLayoutManager(this)
        binding.solRv.adapter = SolrvAdapter
        val bundle=intent.extras
        var value = bundle?.getString("value","none")
        var valu = bundle?.getString("valu","none")

        if (value != null) {
            if (valu != null) {
                db.collection("Solutions").document(value).collection(valu)
                    .get()
                    .addOnSuccessListener { result ->
                        dataList.clear()
                        for (doc in result) {
                            var user = doc.toObject(Userdata::class.java)
                            if (user != null) {
                                user.img?.let { user.little?.let { it1 -> SolRvModel(it, it1) } }
                                    ?.let { dataList.add(it) }
                            }

                        }
                        SolrvAdapter.notifyDataSetChanged()
                    }.addOnFailureListener {

                    }
            }
        }

    }
}