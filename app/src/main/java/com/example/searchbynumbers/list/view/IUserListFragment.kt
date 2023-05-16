package com.example.searchbynumbers.list.view

import com.example.searchbynumbers.data.network.modelList.User

interface IUserListFragment {
    fun showUser(users: ArrayList<User>)
}