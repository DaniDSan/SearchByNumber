package com.example.searchbynumbers.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.searchbynumbers.R
import com.example.searchbynumbers.data.network.UserListRepository
import com.example.searchbynumbers.data.network.modelList.User
import com.example.searchbynumbers.list.UserListAdapter
import com.example.searchbynumbers.list.presenter.UserListPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class UserListFragment : Fragment(), IUserListFragment {
    private lateinit var userListAdapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_users_list, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        userListAdapter = UserListAdapter(this.requireContext(), arrayListOf())
        recyclerView.adapter = userListAdapter
        UserListPresenter(this, UserListRepository())

        return view
    }

    override fun showUser(users: ArrayList<User>) {
        userListAdapter.updateData(users)
    }
}