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
                        val qn4 = Question(4, "What is Kotlin")
                        val qn5 = Question(5, "Is Kotlin open source")
                        val qn6 = Question(6, "Java is developed by")
                        val qn7 = Question(7, "What is an interface")
                        val qn8 = Question(8, "What is a button")
                        val qn9 = Question(9, "Room database is used to")
                        val qn10 = Question(10, "Is kotlin type safe")
                        val qn11 = Question(11, "What is a drawable")
                        val qn12 = Question(12, "The use of manifest file is")
                        val qn13 = Question(13, "Text view helps to")
                        val qn14 = Question(14, "What is spring framework")
                        val qn15 = Question(15, "Where is Hibernate Framework")

                        QuizDatabase(it).getQuestionDao().addQuestion(qn1)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn2)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn3)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn4)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn5)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn6)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn7)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn8)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn9)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn10)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn11)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn12)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn13)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn14)
                        QuizDatabase(it).getQuestionDao().addQuestion(qn15)

                        val a1q1 = Answer(0,1,"No SQL Database",false)
                        val a2q1 = Answer(0,1,"Linux Database",false)
                        val a3q1 = Answer(0,1,"SQL Based Database",true)
                        val a1q2 = Answer(0,2,"C ++",false)
                        val a2q2 = Answer(0,2,"Java",true)
                        val a3q2 = Answer(0,2,"Visual Basic",false)

                        val a1q3 = Answer(0,3,"Databases For Android",false)
                        val a2q3 = Answer(0,3,"Android Activities",false)
                        val a3q3 = Answer(0,3,"Layouts for Android",true)
                        val a1q15 = Answer(0,15,"ORM",true)
                        val a2q15 = Answer(0,15,"NOSQL DB",false)
                        val a3q15 = Answer(0,15,"Web framework",false)

                        val a1q14 = Answer(0,14,"Java based framework",true)
                        val a2q14 = Answer(0,14,"Node based framework",false)
                        val a3q14 = Answer(0,14,"Database framework",false)

                        val a1q13 = Answer(0,13,"Display Image",false)
                        val a2q13 = Answer(0,13,"Display Web view",false)
                        val a3q13 = Answer(0,13,"Display Text ",true)

                        val a1q12 = Answer(0,12,"keep app configuration",true)
                        val a2q12 = Answer(0,12,"work as UI component",false)
                        val a3q12 = Answer(0,12,"Keep Profile Data ",false)

                        val a1q11 = Answer(0,11,"can be image",true)
                        val a2q11 = Answer(0,11,"Database",false)
                        val a3q11 = Answer(0,11,"Activity",false)

                        val a1q10 = Answer(0,10,"No",false)
                        val a2q10 = Answer(0,10,"Yes",true)
                        val a3q10 = Answer(0,10,"Not sure",false)

                        val a1q9 = Answer(0,9,"Store Data",true)
                        val a2q9 = Answer(0,9,"Manage UI",false)
                        val a3q9 = Answer(0,9,"Work as CPU",false)

                        val a1q8 = Answer(0,8,"UI Component",true)
                        val a2q8 = Answer(0,8,"Hardware",false)
                        val a3q8 = Answer(0,8,"Storage Device",false)

                        val a1q7 = Answer(0,7,"Programing language",false)
                        val a2q7 = Answer(0,7,"What the user sees",true)
                        val a3q7 = Answer(0,7,"Database",false)

                        val a1q6 = Answer(0,6,"Google",false)
                        val a2q6 = Answer(0,6,"IBM",false)
                        val a3q6 = Answer(0,6,"Oracle",true)

                        val a1q5 = Answer(0,5,"yes",true)
                        val a2q5 = Answer(0,5,"no",false)
                        val a3q5 = Answer(0,5,"not sure",false)

                        val a1q4 = Answer(0,4,"Database system",false)
                        val a2q4 = Answer(0,4,"Front end framework",false)
                        val a3q4 = Answer(0,4,"programming language",true)

                        QuizDatabase(it).getAnswerDao().addMultipleAnswer(a1q1,a2q1,a3q1,a1q2,a2q2,a3q2,a1q3,a2q3,a3q3,a1q4,a2q4,a3q4,
                        a1q5,a2q5,a3q5,a1q6,a2q6,a3q6,a1q7,a2q7,a3q7,a1q8,a2q8,a3q8,a1q9,a2q9,a3q9,a1q10,a2q10,a3q10,a1q11,a2q11,a3q11
                        ,a1q12,a2q12,a3q12,a1q13,a2q13,a3q13,a1q14,a2q14,a3q14,a1q15,a2q15,a3q15)

                    }
                }

            }
            val action = HomeFragmentDirections.actionHomeFragmentToQuestionFragment3()

            Navigation.findNavController(it).navigate(action)
        }


    }
}