package br.com.andersonluisdev.data.repository

import android.util.Log
import br.com.andersonluisdev.data.api.ApiClient
import br.com.andersonluisdev.data.model.login.LoginResponse
import br.com.andersonluisdev.data.model.profile.ProfileResponse
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class RepositoryImplementation {

    private var token: String? = null

    suspend fun signIn(email: String, password: String): Flow<LoginResponse?> {
        return flow {
            try {
                ApiClient.retrofitInstance.runCatching {
                    signIn(email, password)
                }.apply {
                    this.map { response->
                        if (response.isSuccessful){
                            token = response.body()?.token
                            emit(response.body())
                        } else {
                            val gson = Gson()
                            val errorResponse: LoginResponse = gson.fromJson(
                                response.errorBody()?.charStream(),
                                LoginResponse::class.java
                            )
                            emit(errorResponse)
                        }
                    }
                }
             } catch (t: Throwable) {
                Log.d("Challenge", t.stackTraceToString())
            }
        }
    }

    suspend fun getUserProfile(): Flow<ProfileResponse> = flow {
        emit(ApiClient.retrofitInstance.getUserProfile(token ?: ""))
    }


}
