package com.dakam.dakamquizapp.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.Navigation
import com.dakam.dakamquizapp.R
import com.dakam.dakamquizapp.adapter.AnalyticsAdapter
import com.dakam.dakamquizapp.model.UserResult
import com.google.gson.Gson


class AnalyticsFragment :BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_analytics, container, false)


        val gson = Gson()
        val spf = activity?.getSharedPreferences("results", Context.MODE_PRIVATE)
        var res = spf!!.getString("data", "")
        var list = gson.fromJson(res.toString(), Array<UserResult>::class.java).asList()

        var listView = root.findViewById<ListView>(R.id.listView)


       // if(list !=null){

        val toast= Toast.makeText(context, list.toString(), Toast.LENGTH_LONG)
        toast.show()
            val myAdapter = AnalyticsAdapter(requireActivity(), list)
            listView.adapter = myAdapter
       // }


        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }
}