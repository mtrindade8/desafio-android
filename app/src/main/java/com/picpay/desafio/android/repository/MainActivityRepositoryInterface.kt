package com.picpay.desafio.android.repository

import com.picpay.desafio.android.model.User
import retrofit2.Response

interface MainActivityRepositoryInterface {
    suspend fun loadUsers(): Response<List<User>>
}