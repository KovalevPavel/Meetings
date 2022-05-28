package me.kovp.feature_network.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AuthResponse(
    @SerializedName("token")
    val token: String?
) : Parcelable
