package com.singpaulee.made_dicoding.views.main

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.singpaulee.made_dicoding.adapter.MovieAdapter
import com.singpaulee.made_dicoding.bank.Movie
import com.singpaulee.made_dicoding.listener.MovieListener
import com.singpaulee.made_dicoding.model.MovieModel
import com.singpaulee.made_dicoding.views.base.Presenter

class MainPresenter : Presenter<MainView> {

    private var mainView: MainView? = null

    override fun onAttach(view: MainView) {
        this.mainView = view
    }

    override fun onDetach() {
        mainView = null
    }

    fun setItems(): MutableList<MovieModel> {

        val arrays: Array<MovieModel> = Movie.listMovie

        return mutableListOf(*arrays)
    }

    fun setAdapter(
        list: MutableList<MovieModel>,
        context: Context,
        listener: MovieListener
    ): MovieAdapter {
        return MovieAdapter(list, context, listener)
    }

    fun setLayoutManager(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    fun showRecyclerView() {
        mainView?.onShowRecyclerview()
    }
}