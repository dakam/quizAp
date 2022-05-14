package com.dakam.dakamquizapp.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.dakam.dakamquizapp.R
import com.dakam.dakamquizapp.model.UserResult
import com.dakam.dakamquizapp.repository.Answer
import com.dakam.dakamquizapp.repository.Question
import com.dakam.dakamquizapp.repository.QuizDatabase
import com.google.gson.Gson
import kotlinx.coroutines.launch


class EndFragment :BaseFragment() {
    private lateinit var btn_tryagain: Button
    private lateinit var btn_analysis: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_end, container, false)

        btn_tryagain = root.findViewById<Button>(R.id.btn_tryagain)
        btn_analysis = root.findViewById<Button>(R.id.btn_analysis)

        var totalTV = root.findViewById<TextView>(R.id.total)
        var correctCountTV = root.findViewById<TextView>(R.id.correctNumber)
        var wrongCountTV = root.findViewById<TextView>(R.id.wrongNumber)
        var scoreTV = root.findViewById<TextView>(R.id.score)
        var imgImage = root.findViewById<ImageView>(R.id.img)

        val gson = Gson()
        val spf = activity?.getSharedPreferences("results", Context.MODE_PRIVATE)
        var res = spf!!.getString("data", "")
        var list = gson.fromJson(res.toString(), Array<UserResult>::class.java).asList()

        var score:Int=0;
        var correct:Int =0;
        var wrong:Int=0;
        var total:Int =0;
        if(list !=null){
            for(result in list){

                total++
                if(result.correct==true){
                    correct++;
                    score++;
                }else{
                    wrong++;
                }

            }
        }
        totalTV.text= "Total Questions : "+total;
        correctCountTV.text = "Correct Answers (Score) : "+score
        wrongCountTV.text = "Wrong Answers : "+ wrong
        scoreTV.text = "Your Score is "+ score+ " / "+total;

        if(score >  9){
            imgImage.setBackgroundResource(R.drawable.welldone)
        }else{
            imgImage.setBackgroundResource(R.drawable.tryagain)
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        btn_tryagain.setOnClickListener {

            val action = EndFragmentDirections.actionEndFragmentToQuestionFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btn_analysis.setOnClickListener {

            val action = EndFragmentDirections.actionEndFragmentToAnalyticsFragment()
            Navigation.findNavController(it).navigate(action)
        }


    }
}