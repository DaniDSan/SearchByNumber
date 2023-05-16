package com.example.searchbynumbers.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.searchbynumbers.R
import com.example.searchbynumbers.data.network.modelList.User

class UserListAdapter(private val context: Context, private val dataset: ArrayList<User>) :
    RecyclerView.Adapter<UserListAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.user_login)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.login
    }

    fun updateData(newData: ArrayList<User>) {
        newData.clear()
        dataset.addAll(newData)
        notifyDataSetChanged()
    }
}