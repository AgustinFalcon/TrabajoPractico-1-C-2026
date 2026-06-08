package com.agusstkd.fasekotlin.ui.home

import androidx.lifecycle.LiveData
import com.agusstkd.fasekotlin.data.db.AppDatabase
import com.agusstkd.fasekotlin.model.Persona
import com.agusstkd.fasekotlin.model.User


class UserRepository {

    private val userDao = AppDatabase.getDatabase().userDao()

    val readAllData: LiveData<List<User>> = userDao.readAllData()


    fun insertUser(user: User) {
        userDao.insert(user = user)
    }

    fun updateUser(user: User) {
        userDao.update(user)
    }

    fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    fun deleteAllUsers() {
        userDao.deleteAll()
    }
}