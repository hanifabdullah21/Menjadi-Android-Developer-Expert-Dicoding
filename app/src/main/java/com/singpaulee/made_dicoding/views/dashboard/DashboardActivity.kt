package com.singpaulee.made_dicoding.views.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.singpaulee.made_dicoding.R
import com.singpaulee.made_dicoding.adapter.TabLayoutPagerAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : AppCompatActivity(), DashboardView {

    private var presenter: DashboardPresenter = DashboardPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        onAttachView()
        presenter.setupTabLayout()
    }

    override fun onShowTabLayout() {
        da_viewpager.adapter = TabLayoutPagerAdapter(supportFragmentManager, this)
        da_tab_layout.setupWithViewPager(da_viewpager)
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()
    }
}
