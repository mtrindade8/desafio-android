package com.picpay.desafio.android.repository

import com.picpay.desafio.android.api.RetrofitInstance
import com.picpay.desafio.android.model.User
import retrofit2.Response
import javax.inject.Inject

class MainActivityRepository @Inject constructor(
    private val retrofitInstance: RetrofitInstance
): MainActivityRepositoryInterface {

    override suspend fun loadUsers(): Response<List<User>> {
       return retrofitInstance.service.getUsers()
    }

}