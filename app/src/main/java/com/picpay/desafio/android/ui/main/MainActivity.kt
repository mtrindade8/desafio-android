package com.picpay.desafio.android.ui.main

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.model.User
import com.picpay.desafio.android.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var adapter: UserListAdapter
    private lateinit var viewBinding: ActivityMainBinding
    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewBinding()
        setViews()
        setUserListAdapter()
        setObservers()
        loadUsersList()
    }

    private fun setViewBinding(){
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }

    private fun setViews(){
        recyclerView = viewBinding.recyclerView
        progressBar = viewBinding.userListProgressBar
    }

    private fun setUserListAdapter(){
        adapter = UserListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setUserListContent(userList: List<User>){
        adapter.users = userList
    }

    private fun setObservers(){
        mainActivityViewModel.getUsersList().observe(this, Observer {
            if(it.isNullOrEmpty()){
                showToast(getString(R.string.error))
                showProgressBar(false)
                showRecyclerView(false)
            }else{
                showProgressBar(false)
                setUserListContent(it)
            }
        })
    }

    private fun loadUsersList() {
        mainActivityViewModel.loadUsers()
        showProgressBar(true)
    }

    private fun showToast(message: String){
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT)
            .show()
    }

    private fun showProgressBar(isVisible: Boolean){
        if(isVisible) progressBar.visibility = View.VISIBLE else progressBar.visibility = View.GONE
    }

    private fun showRecyclerView(isVisible: Boolean){
        if(isVisible) recyclerView.visibility = View.VISIBLE else recyclerView.visibility = View.GONE
    }
}
