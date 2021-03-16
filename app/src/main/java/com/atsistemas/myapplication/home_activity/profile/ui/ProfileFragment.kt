package com.atsistemas.myapplication.home_activity.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.atsistemas.myapplication.commons.BaseFragment
import com.atsistemas.myapplication.databinding.ProfileFragmentBinding
import com.atsistemas.myapplication.home_activity.profile.vm.ProfileViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ProfileFragment:BaseFragment() {

    private var _binding: ProfileFragmentBinding? = null
    private val binding get() = _binding!!

    private val presenter: ProfileViewModel by sharedViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = ProfileFragmentBinding.inflate(layoutInflater)

        configureButton()

        return binding.root
    }

    override fun loadObservers() {
        presenter.username.observe(viewLifecycleOwner, {
            binding.tvName.setText(it)
        })
        presenter.usersurname.observe(viewLifecycleOwner, {
            binding.tvSurname.setText(it)
        })
    }

    private fun configureButton(){
        
        binding.buttonApply.setOnClickListener {
            val username = binding.tvName.text.toString()
            val usersurname = binding.tvSurname.text.toString()
            presenter.saveUser(username, usersurname)
        }
    }
}