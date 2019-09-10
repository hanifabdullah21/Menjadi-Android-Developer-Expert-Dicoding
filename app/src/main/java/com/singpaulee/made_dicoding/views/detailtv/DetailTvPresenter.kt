package com.singpaulee.made_dicoding.views.detailtv

import com.singpaulee.made_dicoding.BuildConfig
import com.singpaulee.made_dicoding.connection.NetworkConfig
import com.singpaulee.made_dicoding.connection.NetworkInterface
import com.singpaulee.made_dicoding.views.base.Presenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailTvPresenter : Presenter<DetailTvView> {

    private var detailTvView: DetailTvView? = null
    private var compositeDisposable: CompositeDisposable? = null
    private var apiNetwork: NetworkInterface? = null

    override fun onAttach(view: DetailTvView) {
        this.detailTvView = view
        apiNetwork = NetworkConfig.retrofitConfig().create(NetworkInterface::class.java)
    }

    override fun onDetach() {
        this.detailTvView = null
    }

    fun getDetailTv(id: Int?, language: String) {
        detailTvView?.showLoading()
        val observable = apiNetwork?.getDetailTv(id, BuildConfig.APIKEY, language)

        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()
        }

        compositeDisposable?.add(
            observable!!
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    detailTvView?.hideLoading()
                    if (it?.success == null) {
                        detailTvView?.onShowDetailTv(it)
                    } else {
                        detailTvView?.showErrorMessage("error "+it.statusMessage)
                    }
                }, {
                    detailTvView?.hideLoading()
                    detailTvView?.showErrorMessage("failure "+it.localizedMessage)
                })
        )
    }

}