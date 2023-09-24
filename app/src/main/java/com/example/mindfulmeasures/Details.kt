package com.example.mindfulmeasures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mindfulmeasures.databinding.ActivityDetailsBinding

class Details : AppCompatActivity() {
    private lateinit var binding:ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submit.setOnClickListener{
            var intent= Intent(this,Survey::class.java)
            intent.putExtra("name",binding.name.text.toString())
            startActivity(intent)
        }

    }
}