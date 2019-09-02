package com.singpaulee.made_dicoding.views.base

interface Presenter<T : View> {

    fun onAttach(view: T)

    fun onDetach()
}