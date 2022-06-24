package br.com.andersonluisdev.data.api

import br.com.andersonluisdev.data.model.login.LoginResponse
import br.com.andersonluisdev.data.model.orderdetails.OrderDetailsResponse
import br.com.andersonluisdev.data.model.profile.OrderResponse
import br.com.andersonluisdev.data.model.profile.ProfileResponse
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
    ): ProfileResponse

    @GET("user/profile/orders")
    suspend fun getUserOrders(
        @Query("token") token: String
    ): List<OrderResponse>

    @GET("ser/profile/order_details")
    suspend fun getOrderDetails(
        @Query("token") token: String,
        @Query("orderId") orderId: Int
    ): OrderDetailsResponse
}