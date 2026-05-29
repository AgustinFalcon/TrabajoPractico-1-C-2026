package com.agusstkd.fasekotlin.ui.home.list

import com.agusstkd.fasekotlin.model.User

interface OnUserClick {
    fun onClick(user: User)
}