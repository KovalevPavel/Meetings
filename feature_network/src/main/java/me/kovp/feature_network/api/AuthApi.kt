package me.kovp.feature_network.api

import me.kovp.feature_network.dto.AuthResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @POST("/login")
    @FormUrlEncoded
    suspend fun loginUser(
        @Field("login") userLogin: String,
        @Field("password") userPassword: String
    ): AuthResponse
}