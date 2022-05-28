package me.kovp.feature_network.api

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface BotApi {
    @POST("sendMessage")
    @FormUrlEncoded
    suspend fun sendMessage(
        @Field("chat_id") chatId: String,
        @Field("text") text: String
    ): String

    @GET("getMe")
    suspend fun getMe(): String
}