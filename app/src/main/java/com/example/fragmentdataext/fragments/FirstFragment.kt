package com.example.fragmentdataext.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.fragmentdataext.R
import com.example.fragmentdataext.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

        private var fragmentFirstBinding : FragmentFirstBinding? = null
        private lateinit var communicator: Communicator

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            val binding = FragmentFirstBinding.inflate(inflater, container, false)
            fragmentFirstBinding = binding

            communicator = activity as Communicator

            binding.submitBtn.setOnClickListener {
                communicator.passData(binding.inputT1.text.toString(), binding.inputT2.text.toString(), binding.inputT3.text.toString())
            }
            return fragmentFirstBinding!!.root
        }

        override fun onDestroyView() {
            fragmentFirstBinding = null
            return super.onDestroyView()
        }
    }



