package me.kovp.feature_network.api

import retrofit2.http.GET

interface ProfileInfoApi {
    @GET("/profile")
    suspend fun getProfileInfo(): String
}