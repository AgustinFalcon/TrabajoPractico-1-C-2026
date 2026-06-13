package com.agusstkd.fasekotlin.ui.home.list


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.agusstkd.fasekotlin.databinding.ItemRecyclerviewListUserBinding
import com.agusstkd.fasekotlin.model.User


class ListAdapter(val onUserClick: OnUserClick) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var userList = emptyList<User>()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(userList: List<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }

    inner class ListViewHolder(private val binding: ItemRecyclerviewListUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            with(binding) {
                tvName.text = user.name
                tvId.text = user.id.toString()
                tvDescription.text = user.description

                root.setOnClickListener {
                    onUserClick.onClick(user = user)
                }
            }
            /*binding.tvName.text = user.name
            binding.tvId.text = user.id.toString()
            binding.tvDescription.text = user.description

            binding.root.setOnClickListener {
                onUserClick.onClick(user = user)
            }*/
        }
    }

    override fun onCreateViewHolder(viewGruop: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(viewGruop.context)
        val binding = ItemRecyclerviewListUserBinding.inflate(layoutInflater, viewGruop, false)
        return ListViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) { //0
        val user = userList.get(position)
        holder.bind(user = user)
    }

    override fun getItemCount(): Int = userList.size
}
