package br.com.andersonluisdev.data.remote.api

import br.com.andersonluisdev.data.remote.model.login.LoginResponse
import br.com.andersonluisdev.data.remote.model.orderdetails.OrderDetailsResponse
import br.com.andersonluisdev.data.remote.model.profile.OrderResponse
import br.com.andersonluisdev.data.remote.model.profile.UserProfileResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @FormUrlEncoded
    @POST("auth")
    suspend fun signIn(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<LoginResponse>

    @GET("user/profile")
    suspend fun getUserProfile(
        @Query("token") token: String
    ): Response<UserProfileResponse>

    @GET("user/profile/orders")
    suspend fun getUserOrders(
        @Query("token") token: String
    ): Response<List<OrderResponse>>

    @GET("user/profile/order_details")
    suspend fun getOrderDetails(
        @Query("token") token: String,
        @Query("order_id") orderId: Int
    ): Response<OrderDetailsResponse>
}
