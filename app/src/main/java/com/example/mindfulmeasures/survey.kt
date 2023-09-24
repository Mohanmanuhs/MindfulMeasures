package com.example.mindfulmeasures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mindfulmeasures.databinding.ActivitySurveyBinding

class Survey : AppCompatActivity() {
    private lateinit var binding: ActivitySurveyBinding
    private lateinit var arr:ArrayList<model>
    private var currQues=0
    private var score=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySurveyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent= intent
        binding.heading.text="Hello ${intent.getStringExtra("name")} ,\n Let us know more about you"
        arr=ArrayList()
        arr.add(model("How do you utilize your free time ?", "playing",10,"books",10,"phone",5))
        arr.add(model("How often do you experience information overload in your daily life ?", "Rarely",10,"Occasionally",7,"Often",3))
        arr.add(model("To what extent do you feel pressured by social media ?", " Not at all",10," Slightly",10,"Extremely",5))
        arr.add(model("Have you ever experienced feelings of inadequacy or anxiety due to content you've encountered on social media related to mental health ?", "yes",10,"no",5,"none",0))
        arr.add(model("Do you believe there is a need for better content moderation on social media platforms regarding mental health topics ? ", "yes",10,"no",10,"none",0))
        arr.add(model("How satisfied are you with the current resources available for managing mental health and well-being in online spaces ?", "Very Dissatisfied",10,"Neutral",10,"Satisfied",5))
        arr.add(model("Have you ever encountered online harassment or negative comments related to your mental health on social media platforms ?", "yes",10,"no",10,"none",5))

        binding.ques.text=arr[currQues].question
        binding.opt1.text=arr[currQues].opt1
        binding.opt2.text=arr[currQues].opt2
        binding.opt3.text=arr[currQues].opt3

        binding.opt1.setOnClickListener{
            score+=arr[currQues].pt1
            currQues++
            nextquestion()
        }
        binding.opt2.setOnClickListener{
            currQues++
            score+=arr[currQues].pt2
            nextquestion()
        }
        binding.opt3.setOnClickListener{
            currQues++
            score+=arr[currQues].pt3
            nextquestion()
        }
    }

    private fun nextquestion() {
        if (currQues<arr.size){
            binding.ques.text=arr[currQues].question
            binding.opt1.text=arr[currQues].opt1
            binding.opt2.text=arr[currQues].opt2
            binding.opt3.text=arr[currQues].opt3
        }else{
            startActivity(Intent(this,MainActivity2::class.java))

        }
    }
}
