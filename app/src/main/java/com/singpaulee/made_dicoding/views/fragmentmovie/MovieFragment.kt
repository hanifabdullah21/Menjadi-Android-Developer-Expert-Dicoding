package com.singpaulee.made_dicoding.views.fragmentmovie


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.singpaulee.made_dicoding.R
import com.singpaulee.made_dicoding.bank.ConstantTemplate
import kotlinx.android.synthetic.main.fragment_movie.view.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_movie, container, false)


        val arg = arguments?.getString(ConstantTemplate.ARG_KEY_MOVIE)
        rootView.mf_tv_test.text = arg

        return rootView
    }


}
