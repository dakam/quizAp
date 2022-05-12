package com.dakam.dakamquizapp.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.dakam.dakamquizapp.R
import com.dakam.dakamquizapp.model.UserResult

class AnalyticsAdapter (private val context: FragmentActivity, private val data: List<UserResult>)
    : ArrayAdapter<String>(context, R.layout.custom_analytics) {

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.custom_analytics, null, true)

        val questionText = rowView.findViewById(R.id.questionT) as TextView
        val imageView = rowView.findViewById(R.id.img) as ImageView
        val yourAnswerText = rowView.findViewById(R.id.youranswer) as TextView
        val CorrectAnswerText = rowView.findViewById(R.id.correctanswer) as TextView

        questionText.text = data.get(position).question
        if(data.get(position).correct==true){
            imageView.setBackgroundResource(R.drawable.correct)
        }else {
            imageView.setBackgroundResource(R.drawable.wrong)

        }
        yourAnswerText.text =  data.get(position).yourAnswer
        CorrectAnswerText.text =  data.get(position).correctAnswer

        return rowView
    }
}