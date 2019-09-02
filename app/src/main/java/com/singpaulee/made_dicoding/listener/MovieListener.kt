package com.singpaulee.made_dicoding.listener

import com.singpaulee.made_dicoding.model.MovieModel

interface MovieListener {

    fun onMovieClicked(movie: MovieModel?)
}