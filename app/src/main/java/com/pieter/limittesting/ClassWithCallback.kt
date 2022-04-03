package com.pieter.limittesting

import androidx.annotation.VisibleForTesting

class ClassWithCallback {

    @VisibleForTesting
    val successValue = "foo"

    @VisibleForTesting
    val errorValue = "bar"

    fun invokeApiCall(callback: (String) -> Unit) {
        callback.invoke("foobar")
    }

    fun invokeApiCall(callbackClassModel: CallbackClassModel, apiResult: ApiResult) {
        if (callbackClassModel.shouldSucceed) {
            apiResult.onSuccess(successValue)
        } else {
            apiResult.onError(errorValue)
        }
    }

    data class CallbackClassModel(
        val shouldSucceed: Boolean
    )

    interface ApiResult {
        fun onSuccess(result: String)
        fun onError(error: String)
    }
}