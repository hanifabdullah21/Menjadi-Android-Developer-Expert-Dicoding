package com.singpaulee.made_dicoding.adapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.singpaulee.made_dicoding.R
import com.singpaulee.made_dicoding.bank.ConstantTemplate
import com.singpaulee.made_dicoding.views.fragmentmovie.MovieFragment

class TabLayoutPagerAdapter(fm: FragmentManager, private val context: Context) :
    FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val movieFragment = MovieFragment()
        val bundleMovie = Bundle()
        when (position) {
            0 -> bundleMovie.putString(ConstantTemplate.ARG_KEY_MOVIE, ConstantTemplate.ARG_MOVIE)
            1 -> bundleMovie.putString(ConstantTemplate.ARG_KEY_MOVIE, ConstantTemplate.ARG_TV)
        }
        movieFragment.arguments = bundleMovie
        return movieFragment
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> context.resources.getString(R.string.string_tablayout_title_movie)
            1 -> context.resources.getString(R.string.string_tablayout_title_tv)
            else -> "Null"
        }
    }
}