package com.singpaulee.made_dicoding.connection

import android.util.Log
import io.reactivex.Observer
import retrofit2.HttpException


abstract class NetworkCallback<M> : Observer<M> {

    private val tag = NetworkCallback::class.java.name

    abstract fun onSuccess(model: M)

    abstract fun onFailure(message: String)

    abstract fun onFinish()

    override fun onComplete() {
        onFinish()
    }

    override fun onNext(t: M) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        if (e is HttpException) {
            val code = e.code()
            val message = e.localizedMessage.toString()
            Log.i(tag, "code : $code")
            onFailure(message)
        } else {
            onFailure(e.localizedMessage.toString())
        }
        onFinish()
    }


}