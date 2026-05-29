package com.agusstkd.fasekotlin.ui.home.list


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.agusstkd.fasekotlin.databinding.ItemRecyclerviewListUserBinding
import com.agusstkd.fasekotlin.model.User


class ListAdapter(val onUserClick: OnUserClick) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var userList = listOf<User>(
        User(1, "Pepe", "Mujica"),
        User(2, "Mary", "Jane"),
        User(3, "Leo", "Messi"),
        User(4, "Dibu", "Martinez"),
        User(5, "Pepe", "Mujica"),
        User(6, "Mary", "Jane"),
        User(7, "Leo", "Messi"),
        User(8, "Dibu", "Martinez"),
    )

    inner class ListViewHolder(val binding: ItemRecyclerviewListUserBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(viewGruop: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(viewGruop.context)
        val binding = ItemRecyclerviewListUserBinding.inflate(layoutInflater, viewGruop, false)
        return ListViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) { //0
        val user = userList.get(position)
        holder.binding.tvName.text = user.name
        holder.binding.tvId.text = user.id.toString()
        holder.binding.tvDescription.text = user.description

        holder.binding.root.setOnClickListener {
            onUserClick.onClick(user = user)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}