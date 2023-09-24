package com.example.mindfulmeasures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
       var navcontroller=findNavController(R.id.fragmentContainerView3)
        var bottomBar=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomBar.setupWithNavController(navcontroller)



    }
}