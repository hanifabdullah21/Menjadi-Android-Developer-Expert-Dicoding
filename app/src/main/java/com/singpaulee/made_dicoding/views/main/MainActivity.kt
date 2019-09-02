package com.singpaulee.made_dicoding.views.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.singpaulee.made_dicoding.R
import com.singpaulee.made_dicoding.listener.MovieListener
import com.singpaulee.made_dicoding.model.MovieModel
import com.singpaulee.made_dicoding.views.detailmovie.DetailMovieActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity(), MainView, MovieListener {

    var presenter : MainPresenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onAttachView()
        presenter.showRecyclerView()
    }

    override fun onShowRecyclerview() {
        val list = presenter.setItems()
        val adapter = presenter.setAdapter(list, this, this)
        val layoutManager = presenter.setLayoutManager(this)

        main_recyclerview.layoutManager = layoutManager
        main_recyclerview.adapter = adapter
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }

    override fun onMovieClicked(movie: MovieModel?) {
        startActivity(intentFor<DetailMovieActivity>("movie" to movie))
        toast(movie?.title.toString())
    }

}
