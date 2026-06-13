package com.agusstkd.fasekotlin.ui.home

import androidx.lifecycle.LiveData
import com.agusstkd.fasekotlin.data.db.AppDatabase
import com.agusstkd.fasekotlin.model.Persona
import com.agusstkd.fasekotlin.model.User


class UserRepository {

    private val userDao = AppDatabase.getDatabase().userDao()

    val readAllData: LiveData<List<User>> = userDao.readAllData()


    suspend fun insertUser(user: User) {
        userDao.insert(user = user)
    }

    suspend fun updateUser(user: User) {
        userDao.update(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUsers() {
        userDao.deleteAll()
    }
}