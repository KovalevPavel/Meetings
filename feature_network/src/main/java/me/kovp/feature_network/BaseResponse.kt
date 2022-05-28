package me.kovp.feature_network

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BaseResponse<T : Any>(
    val status: ResponseStatus,
//    val payload: T? = null
): Parcelable {
    @Parcelize
    data class ResponseStatus(
        val success: Boolean = true,
        val statusCode: Int = SUCCESS_RESPOND_CODE,
        val message: String = "",
    ): Parcelable

    companion object {
        private const val SUCCESS_RESPOND_CODE = 200
    }
}