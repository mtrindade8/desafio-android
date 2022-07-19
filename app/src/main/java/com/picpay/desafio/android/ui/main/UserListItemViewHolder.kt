package com.picpay.desafio.android.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.model.User
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class UserListItemViewHolder(
    private val listItemUserBinding: ListItemUserBinding
) : RecyclerView.ViewHolder(listItemUserBinding.root) {

    fun bind(user: User) {
        listItemUserBinding.name.text = user.name
        listItemUserBinding.username.text = user.username
        listItemUserBinding.progressBar.visibility = View.VISIBLE
        Picasso.get()
            .load(user.img)
            .error(R.drawable.ic_round_account_circle)
            .into(listItemUserBinding.picture, object : Callback {
                override fun onSuccess() {
                    listItemUserBinding.progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    listItemUserBinding.progressBar.visibility = View.GONE
                }
            })
    }
}