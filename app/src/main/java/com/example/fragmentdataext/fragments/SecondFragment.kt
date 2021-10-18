package com.example.fragmentdataext.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.fragmentdataext.databinding.FragmentSecondBinding
import androidx.navigation.fragment.navArgs
import com.example.fragmentdataext.R


class SecondFragment : Fragment(R.layout.fragment_second) {

    private var textName: String? = ""
    private var textStack: String? = ""
    private var textGoals: String? = ""
    private var fragmentSecondBinding : FragmentSecondBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentSecondBinding.inflate(inflater, container, false)
        fragmentSecondBinding = binding
        textName = arguments?.getString("name")
        textStack = arguments?.getString("stack")
        textGoals = arguments?.getString("goals")
       // binding.tv.text = "Your name is ${textName}. \nYou have chosen the ${textStack} track. \n Your ${textGoals} is to be the best and secure a job"

        binding.textName.text =  textName
        binding.textTrack.text = textStack
        binding.textGoal.text = textGoals
        return fragmentSecondBinding!!.root
    }

    override fun onDestroyView() {
        fragmentSecondBinding = null
        return super.onDestroyView()
    }



}
