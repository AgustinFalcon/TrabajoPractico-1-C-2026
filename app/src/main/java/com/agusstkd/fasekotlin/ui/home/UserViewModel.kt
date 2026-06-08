package com.agusstkd.fasekotlin.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.agusstkd.fasekotlin.model.User

class UserViewModel : ViewModel() {

    private val repository = UserRepository()
    val readAllData: LiveData<List<User>> = repository.readAllData

    fun insert(user: User) {
        repository.insertUser(user)
    }

    fun updateUser(user: User) {
        repository.updateUser(user)
    }

    fun deleteUser(user: User) {
        repository.deleteUser(user)
    }

    fun deleteAllUsers() {
        repository.deleteAllUsers()
    }

}