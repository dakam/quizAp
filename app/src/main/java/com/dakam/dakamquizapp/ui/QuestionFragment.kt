package com.dakam.dakamquizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.dakam.dakamquizapp.R

class QuestionFragment : Fragment() {
    private var btn_next: Button? = null
    private var btn_home: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_question, container, false)

        btn_next = root.findViewById<Button>(R.id.btn_start)
        btn_home = root.findViewById<Button>(R.id.btn_home)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_next?.setOnClickListener {

        }
        btn_home?.setOnClickListener {
            val action = QuestionFragmentDirections.actionQuestionFragmentToHomeFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }
}