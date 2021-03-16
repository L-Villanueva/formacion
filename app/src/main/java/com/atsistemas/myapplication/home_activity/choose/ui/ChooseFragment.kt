package com.atsistemas.myapplication.home_activity.choose.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.atsistemas.myapplication.R
import com.atsistemas.myapplication.commons.BaseFragment
import com.atsistemas.myapplication.databinding.ChooseFragmentBinding

class ChooseFragment: BaseFragment() {

    private var _binding: ChooseFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = ChooseFragmentBinding.inflate(layoutInflater)

        configureButtons()

        return binding.root
    }

    private fun configureButtons(){

        binding.buttonListSelect.text = getString(R.string.go_to_list)
        binding.buttonProfileSelect.text = getString(R.string.go_to_profile)
        binding.buttonListSelect.setOnClickListener {
            findNavController().navigate(R.id.action_chooseFragment_to_homeFragment)
        }
        binding.buttonProfileSelect.setOnClickListener {
            findNavController().navigate(R.id.action_chooseFragment_to_profileFragment)
        }
    }

    override fun loadObservers() {

    }

}