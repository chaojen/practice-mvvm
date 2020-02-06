package com.chaojen.mvvmpatternpractice.api

import androidx.annotation.Nullable
import retrofit2.Response
import java.io.IOException

class ApiResponse<T> {

    var code: Int

    @Nullable
    var body: T?

    @Nullable
    var errorMessage: String?

    constructor(error: Throwable) {
        code = 500
        body = null
        errorMessage = error.message
    }

    constructor(response: Response<T>) {
        code = response.code()
        if (response.isSuccessful) {
            body = response.body()
            errorMessage = null
        } else {
            var message: String? = null
            if (response.errorBody() != null) {
                try {
                    message = response.errorBody()!!.string()
                } catch (ignored: IOException) { }
            }
            if (message == null || message.trim().isEmpty()) {
                message = response.message()
            }
            errorMessage = message
            body = null
        }
    }

    fun isSuccessful(): Boolean {
        return code in 200..299
    }
}