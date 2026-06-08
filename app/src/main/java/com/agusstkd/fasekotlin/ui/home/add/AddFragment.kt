package com.agusstkd.fasekotlin.ui.home.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.agusstkd.fasekotlin.R
import com.agusstkd.fasekotlin.databinding.FragmentAddBinding
import com.agusstkd.fasekotlin.model.Persona
import com.agusstkd.fasekotlin.model.User
import com.agusstkd.fasekotlin.ui.home.UserViewModel
import kotlinx.coroutines.Runnable


class AddFragment : Fragment() {

    private val userViewModel: UserViewModel by viewModels()

    private lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString()
            val desc = binding.etDesc.text.toString()
            val age = binding.etAge.text.toString()
            if (name.isNotBlank() && desc.isNotBlank() && age.isNotBlank()) {
                val user = User(id = 0, name = name, description = desc, age = age.toInt())
                userViewModel.insert(user = user)
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }
        }
    }
}