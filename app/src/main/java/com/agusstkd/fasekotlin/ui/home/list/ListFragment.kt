package com.agusstkd.fasekotlin.ui.home.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.agusstkd.fasekotlin.databinding.FragmentListBinding
import com.agusstkd.fasekotlin.model.User

class ListFragment : Fragment(), OnUserClick {

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
    }

    override fun onClick(user: User) {
        Toast.makeText(requireContext(), "Bienvenido/a: ${user.name} + ${user.id}", Toast.LENGTH_SHORT).show()
    }
}