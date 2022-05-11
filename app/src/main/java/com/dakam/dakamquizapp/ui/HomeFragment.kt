package com.dakam.dakamquizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.dakam.dakamquizapp.R
import com.dakam.dakamquizapp.repository.Answer
import com.dakam.dakamquizapp.repository.Question
import com.dakam.dakamquizapp.repository.QuizDatabase
import kotlinx.coroutines.launch


class HomeFragment  :BaseFragment() {
    private var btn_start: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        btn_start = root.findViewById<Button>(R.id.btn_start)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        btn_start?.setOnClickListener {

            launch {

                context?.let {
                    val questions = QuizDatabase(it).getQuestionDao().getAllQuestions()
                    if (questions.size < 1) {
                        val qn1 = Question(1, "What is a Room Database")
                        val qn2 = Question(2, "What language is Kotlin based from")
                        val qn3 = Question(3, "Where is XML Used in developing Android Apps")
                        QuizDatabase(it).getQuestionDao().addQuestion(qn1)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn2)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn3)

                        val a1q1 = Answer(0,1,"No SQL Database")
                        val a2q1 = Answer(0,1,"Linux Database")
                        val a3q1 = Answer(0,1,"SQL Based Database")
                        val a1q2 = Answer(0,2,"C ++")
                        val a2q2 = Answer(0,2,"Java")
                        val a3q2 = Answer(0,2,"Visual Basic")

                        val a1q3 = Answer(0,3,"Databases For Android")
                        val a2q3 = Answer(0,3,"Android Activities")
                        val a3q3 = Answer(0,3,"Layouts for Android")

                        QuizDatabase(it).getAnswerDao().addMultipleAnswer(a1q1,a2q1,a3q1,a1q2,a2q2,a3q2,a1q3,a2q3,a3q3)







                    }
                }


            }
            val action = HomeFragmentDirections.actionHomeFragmentToQuestionFragment3()

            Navigation.findNavController(it).navigate(action)
        }


    }
}