package com.example.searchbynumbers.list.presenter

import com.example.searchbynumbers.data.network.UserListRepository
import com.example.searchbynumbers.list.view.IUserListFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserListPresenter(
    private val view: IUserListFragment,
    private val userListRepository: UserListRepository
) {
    init {
        CoroutineScope(Dispatchers.Main).launch {
            val users = userListRepository.getUser()
            view.showUser(users)
        }
    }
}