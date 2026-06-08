package com.agusstkd.fasekotlin.ui.home.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.agusstkd.fasekotlin.R
import com.agusstkd.fasekotlin.databinding.FragmentUpdateBinding
import com.agusstkd.fasekotlin.model.User
import com.agusstkd.fasekotlin.ui.home.UserViewModel
import kotlin.random.Random


class UpdateFragment : Fragment() {

    private val viewModel: UserViewModel by viewModels()

    private lateinit var binding: FragmentUpdateBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user = arguments?.getSerializable("user") as User

        binding.etName.setText(user.name)
        binding.etDesc.setText(user.description)
        binding.etAge.setText(user.age.toString())


        binding.btnUpdateUser.setOnClickListener {
            val name = binding.etName.text.toString()
            val desc = binding.etDesc.text.toString()
            val age = binding.etAge.text.toString()

            if (name.isNotBlank() && desc.isNotBlank() && age.isNotBlank()) {
                val userCopy = user.copy(name = name, description = desc, age = age.toInt())
                viewModel.updateUser(userCopy)
                findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            }
        }


        binding.btndeleteUser.setOnClickListener {
            viewModel.deleteUser(user)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
    }

}