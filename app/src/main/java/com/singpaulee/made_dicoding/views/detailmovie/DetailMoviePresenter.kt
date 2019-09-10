package com.singpaulee.made_dicoding.views.detailmovie

import android.annotation.SuppressLint
import com.singpaulee.made_dicoding.BuildConfig
import com.singpaulee.made_dicoding.connection.NetworkConfig
import com.singpaulee.made_dicoding.connection.NetworkInterface
import com.singpaulee.made_dicoding.helper.HelperClass
import com.singpaulee.made_dicoding.views.base.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailMoviePresenter : Presenter<DetailMovieView> {

    private var detailMovieView: DetailMovieView? = null
    private var compositeDisposable: CompositeDisposable? = null
    private var apiNetwork: NetworkInterface? = null

    override fun onAttach(view: DetailMovieView) {
        this.detailMovieView = view
        apiNetwork = NetworkConfig.retrofitConfig().create(NetworkInterface::class.java)
    }

    override fun onDetach() {
        this.detailMovieView = null
    }

    fun getDetailMovie(id: Int?, language: String) {
        detailMovieView?.showLoading()
        val observable = apiNetwork?.getDetailMovie(id, BuildConfig.APIKEY, language)

        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }

        compositeDisposable?.add(
            observable!!
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    detailMovieView?.hideLoading()
                    if (it?.success == null) {
                        detailMovieView?.onShowDetailMovie(it)
                    } else {
                        detailMovieView?.showErrorMessage(it.statusMessage)
                    }
                }, {
                    detailMovieView?.hideLoading()
                    detailMovieView?.showErrorMessage(it.localizedMessage)
                })
        )
    }

    @SuppressLint("SimpleDateFormat")
    fun getYearFromDate(dateString: String): String {
        return HelperClass.getYearFromDate(dateString)
    }

    fun convertDuration(runtime: Int?): String {
        return HelperClass.convertDuration(runtime)
    }
}