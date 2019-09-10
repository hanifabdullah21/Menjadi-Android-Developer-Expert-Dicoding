package com.singpaulee.made_dicoding.listener

import com.singpaulee.made_dicoding.model.DescriptionMovieModel
import com.singpaulee.made_dicoding.model.DescriptionTvModel

interface ItemviewAdapterListener {

    interface MovieListener{
        fun onMovieOnClickListener(model: DescriptionMovieModel?)
    }

    interface TvListener{
        fun onTvOnClickListener(model: DescriptionTvModel?)
    }
}