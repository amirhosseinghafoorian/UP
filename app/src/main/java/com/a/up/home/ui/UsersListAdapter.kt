package com.a.up.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.a.up.databinding.EpoxyListItemBinding
import com.a.up.user.model.Data


class UsersListAdapter(diffCallback: DiffUtil.ItemCallback<Data>) :
    PagingDataAdapter<Data, UserViewHolder>(diffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = EpoxyListItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind.username = item?.last_name
    }
}

class UserViewHolder(var bind: EpoxyListItemBinding) : RecyclerView.ViewHolder(bind.root)