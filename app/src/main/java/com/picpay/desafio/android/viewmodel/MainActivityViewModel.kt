package com.picpay.desafio.android.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.api.cache.PicPayCache
import com.picpay.desafio.android.model.User
import com.picpay.desafio.android.repository.MainActivityRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val mainActivityRepository: MainActivityRepositoryInterface,
    private val picPayCache: PicPayCache
): ViewModel() {

    private val usersList : MutableLiveData<List<User>> = MutableLiveData()
    fun getUsersList(): LiveData<List<User>> {
        return usersList
    }

    fun loadUsers(){

        if(picPayCache.userList.isEmpty()){
            viewModelScope.launch {
                val response = mainActivityRepository.loadUsers()
                if(response.isSuccessful){
                    usersList.value = response.body()
                    picPayCache.userList = response.body()!!
                }else{
                    usersList.value = emptyList()
                }
            }
        }else{
            usersList.setValue(picPayCache.userList)
        }
    }
}