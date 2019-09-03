package com.singpaulee.made_dicoding.connection

import android.util.Log
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import retrofit2.HttpException


abstract class NetworkCallback<M> : Subscriber<M> {

    private val TAG = NetworkCallback::class.java.name

    abstract fun onSuccess(model: M)

    abstract fun onFailure(message: String)

    abstract fun onFinish()

    override fun onComplete() {
        onFinish()
    }

    override fun onSubscribe(s: Subscription?) {

    }

    override fun onNext(t: M) {
        onSuccess(t)
    }

    override fun onError(t: Throwable?) {
        t?.printStackTrace()
        if (t is HttpException) {
            val httpException = t as HttpException
            val code = httpException.code()
            val message = httpException.localizedMessage.toString()
            Log.i(TAG, "code : $code")
            onFailure(message)
        } else {
            onFailure(t?.localizedMessage.toString())
        }
        onFinish()
    }


}