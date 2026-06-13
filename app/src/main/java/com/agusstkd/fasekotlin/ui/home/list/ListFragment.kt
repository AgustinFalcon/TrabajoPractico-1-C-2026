package com.agusstkd.fasekotlin.ui.home.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.agusstkd.fasekotlin.R
import com.agusstkd.fasekotlin.databinding.FragmentListBinding
import com.agusstkd.fasekotlin.model.User
import com.agusstkd.fasekotlin.ui.home.UserViewModel
import kotlin.random.Random

class ListFragment : Fragment(), OnUserClick {

    private val viewModel: UserViewModel by viewModels()

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layout = LinearLayoutManager(requireContext())
        val adapter = ListAdapter(this)
        binding.userRecyclerView.layoutManager = layout
        binding.userRecyclerView.adapter = adapter


        // Linea divisoria
        val divider = DividerItemDecoration(requireContext(), layout.orientation)
        binding.userRecyclerView.addItemDecoration(divider)


        viewModel.readAllData.observe(viewLifecycleOwner) { personList ->
            adapter.setList(personList)
        }

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        binding.btnDelete.setOnClickListener {
            showPopup()
        }
    }

    override fun onClick(user: User) {
        val bundle = Bundle()
        bundle.putSerializable("user", user)
        findNavController().navigate(R.id.action_listFragment_to_updateFragment, bundle)
        Toast.makeText(requireContext(), "Bienvenido/a: ${user.name} + ${user.id}", Toast.LENGTH_SHORT).show()
    }


    private fun showPopup() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("¡ALERTA!")
        builder.setMessage("Esta seguro que quiere eliminar toda la base de datos?")

        builder.setPositiveButton("Aceptar") { dialog, _ ->
            deleteAllUsers()
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.dismiss()
        }

        builder.show()
    }


    private fun deleteAllUsers() {
        viewModel.deleteAllUsers()
    }
}