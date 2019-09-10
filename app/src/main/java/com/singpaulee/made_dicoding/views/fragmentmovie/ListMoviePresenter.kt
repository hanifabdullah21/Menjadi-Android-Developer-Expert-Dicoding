package com.singpaulee.made_dicoding.views.fragmentmovie

import android.annotation.SuppressLint
import com.singpaulee.made_dicoding.BuildConfig
import com.singpaulee.made_dicoding.bank.ConstantTemplate
import com.singpaulee.made_dicoding.connection.NetworkConfig
import com.singpaulee.made_dicoding.connection.NetworkInterface
import com.singpaulee.made_dicoding.views.base.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*


class ListMoviePresenter : Presenter<ListMovieView> {

    private var listMovieView: ListMovieView? = null
    private var compositeDisposable: CompositeDisposable? = null
    private var apiNetwork: NetworkInterface? = null

    override fun onAttach(view: ListMovieView) {
        this.listMovieView = view
        apiNetwork = NetworkConfig.retrofitConfig().create(NetworkInterface::class.java)
    }

    override fun onDetach() {
        this.listMovieView = null
    }

    fun getListMovieOrTvShow(type: String?) {
        when (type) {
            ConstantTemplate.ARG_MOVIE -> getListMovieNowPlaying()
            ConstantTemplate.ARG_TV -> getListTvAiringToday()
        }
    }

    private fun getListTvAiringToday() {
        val language = Locale.getDefault().language
        val observable = apiNetwork?.getListTvAiringToday(BuildConfig.APIKEY, language)

        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable?.add(
            observable!!
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listMovieView?.hideLoading()
                    if (it?.success == null) {
                        listMovieView?.onShowListTv(it?.result)
                    } else {
                        listMovieView?.showErrorMessage(it.statusMessage)
                    }
                }, {
                    listMovieView?.hideLoading()
                    listMovieView?.showErrorMessage(it.localizedMessage)
                })
        )
    }

    @SuppressLint("CheckResult")
    private fun getListMovieNowPlaying() {
        val language = Locale.getDefault().language
        val observable = apiNetwork?.getListMovieNowPlaying(BuildConfig.APIKEY, "ID", language)

        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable?.add(
            observable!!
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listMovieView?.hideLoading()
                    if (it?.success == null) {
                        listMovieView?.onShowListMovie(it?.result)
                    } else {
                        listMovieView?.showErrorMessage(it.statusMessage)
                    }
                }, {
                    listMovieView?.hideLoading()
                    listMovieView?.showErrorMessage(it.localizedMessage)
                })
        )
    }
}
