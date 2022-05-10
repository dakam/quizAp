package com.dakam.dakamquizapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.dakam.dakamquizapp.R


class HomeFragment : Fragment() {
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
             val action = HomeFragmentDirections.actionHomeFragmentToQuestionFragment3()

             Navigation.findNavController(it).navigate(action)
        }

    }
}