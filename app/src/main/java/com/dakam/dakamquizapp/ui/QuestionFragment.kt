package com.dakam.dakamquizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.dakam.dakamquizapp.R
import com.dakam.dakamquizapp.repository.Question
import com.dakam.dakamquizapp.repository.QuizDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuestionFragment : BaseFragment() {
    private var btn_next: Button? = null
    private var btn_home: Button? = null
    private var txt_view: TextView? = null
    private var questions: List<Question>?=null
    private var currentIndex: Int =0;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_question, container, false)

        btn_next = root.findViewById<Button>(R.id.btn_next)
        btn_home = root.findViewById<Button>(R.id.btn_home)
        txt_view = root.findViewById<TextView>(R.id.qtn)

        return root
    }

    fun displayQuestion(){
       if(questions !=null ){
           if(currentIndex <= questions!!.size-1){
               txt_view?.setText(questions?.get(currentIndex)?.qtn)
           }
       }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_next?.setOnClickListener {
            currentIndex++;
            displayQuestion();
        }
        btn_home?.setOnClickListener {
            val action = QuestionFragmentDirections.actionQuestionFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }

        launch {
            context?.let{
                questions = QuizDatabase(it).getQuestionDao().getAllQuestions()
                displayQuestion()

            }
        }

    }
}