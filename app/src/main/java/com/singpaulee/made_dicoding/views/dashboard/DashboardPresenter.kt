package com.singpaulee.made_dicoding.views.dashboard

import com.singpaulee.made_dicoding.views.base.Presenter

class DashboardPresenter : Presenter<DashboardView> {

    private var dashboardView : DashboardView? = null

    override fun onAttach(view: DashboardView) {
        this.dashboardView = view
    }

    override fun onDetach() {
        this.dashboardView = null
    }

    fun setupTabLayout(){

        dashboardView?.onShowTabLayout()
    }
}