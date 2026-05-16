package com.agusstkd.fasekotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.agusstkd.fasekotlin.R
import com.agusstkd.fasekotlin.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val secondViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        binding.etName.addTextChangedListener { email ->
            secondViewModel.validateEmail(email = email.toString())
        }

        binding.etPassword.addTextChangedListener { password ->
            secondViewModel.validatePassword(password = password.toString())
        }

        secondViewModel.viewState.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                SecondStatesSealed.SuccessEmail -> {
                    binding.layoutEmail.error = null
                }

                SecondStatesSealed.ErrorEmail -> {
                    binding.layoutEmail.error = "Formato de email invalido"
                }

                SecondStatesSealed.SuccessPassword -> {
                    binding.layoutPassword.error = null
                }

                is SecondStatesSealed.ErrorPassword -> {
                    binding.layoutPassword.error = "${state.password.length}/4"
                }

                SecondStatesSealed.ErrorButton -> {
                    binding.btnNext.isEnabled = false
                }

                SecondStatesSealed.SuccessButton -> {
                    binding.btnNext.isEnabled = true
                }
            }
        })
    }


}