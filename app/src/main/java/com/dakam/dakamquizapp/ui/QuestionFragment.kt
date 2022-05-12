package com.dakam.dakamquizapp.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.navigation.Navigation
import com.dakam.dakamquizapp.R
import com.dakam.dakamquizapp.model.UserResult
import com.dakam.dakamquizapp.repository.Answer
import com.dakam.dakamquizapp.repository.Question
import com.dakam.dakamquizapp.repository.QuizDatabase
import com.google.gson.Gson
import kotlinx.coroutines.launch

class QuestionFragment : BaseFragment() {
    private var btn_next: Button? = null
    private var btn_home: Button? = null
    private var radioG: RadioGroup? = null
    private var radiobtn1: RadioButton?=null;
    private var radiobtn2: RadioButton?=null;
    private var radiobtn3: RadioButton?=null;
    private var txt_view: TextView? = null
    private var questions: List<Question>?=null
    private var answers: List<Answer>?=null
    private var currentCorrect: String=""
    private var currentQuestion: Question?=null
    private var currentIndex: Int =0;
    private var results =mutableListOf<UserResult>()
    private var  root: View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_question, container, false)

        btn_next = root?.findViewById<Button>(R.id.btn_next)
        btn_home = root?.findViewById<Button>(R.id.btn_home)
        txt_view = root?.findViewById<TextView>(R.id.qtn)
        radioG = root?.findViewById<RadioGroup>(R.id.radioG)
        radiobtn1 = root?.findViewById<RadioButton>(R.id.radiobtn1)
        radiobtn2 = root?.findViewById<RadioButton>(R.id.radiobtn2)
        radiobtn3 = root?.findViewById<RadioButton>(R.id.radiobtn3)

        return root
    }



    fun displayQuestion(){
       if(questions !=null ){
           radioG?.clearCheck()

           if(currentIndex <= questions!!.size-1){
               var num = currentIndex+1;
               txt_view?.setText(num.toString() +". "+questions?.get(currentIndex)?.qtn)
               var qtnId = questions?.get(currentIndex)?.id
               currentQuestion= questions?.get(currentIndex)
               var count:Int =0;
               currentCorrect=""
               for(ans in answers!!){
                   if(ans.questionId.equals(qtnId)){
                       count=count+1;
                       if(ans.correct==true){
                           currentCorrect = ans.ans
                       }

                       if(count==1){
                           radiobtn1?.setText(ans.ans)
                       }

                       if(count==2){
                           radiobtn2?.setText(ans.ans)
                       }

                       if(count==3){
                           radiobtn3?.setText(ans.ans)
                       }
                   }
               }
           }
       }

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {

            }

        })

        btn_next?.setOnClickListener {

            val checkedItemId: Int? = radioG?.checkedRadioButtonId
            if(checkedItemId ==-1){
           var toast : Toast =  Toast.makeText(context, "Please select your answer",Toast.LENGTH_LONG)
             toast.show();
            }else {

                if(currentIndex <= questions!!.size){
                    val checkedItemId: Int? = radioG?.checkedRadioButtonId
                    var selectedAnswerOption = root?.findViewById<RadioButton>(checkedItemId!!)
                    var selectedText = selectedAnswerOption!!.text.toString();
                    var currentQuestionText = currentQuestion!!.qtn
                    var isCorrect = selectedText.equals(currentCorrect.toString());

                   var uResult = UserResult(currentQuestion!!.id,currentQuestionText,selectedText,currentCorrect,isCorrect);
                    results.add(uResult);


                }

                if(currentIndex>= questions!!.size-1){

                    val Sharedpreference = activity?.getSharedPreferences("results", Context.MODE_PRIVATE)
                    val gson = Gson();
                    val resultsGson = gson.toJson(results)
                    var edit = Sharedpreference!!.edit();
                    edit.putString("data", resultsGson)
                    edit.apply()



                    val action = QuestionFragmentDirections.actionQuestionFragmentToEndFragment()
                    Navigation.findNavController(it).navigate(action)
                }


                currentIndex++;
                displayQuestion();
            }
        }
        btn_home?.setOnClickListener {
            val action = QuestionFragmentDirections.actionQuestionFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }

        launch {
            context?.let{
                questions = QuizDatabase(it).getQuestionDao().getAllQuestions()
                answers = QuizDatabase(it).getAnswerDao().getAllAnswers()
                displayQuestion()

            }
        }

    }
}