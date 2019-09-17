package com.singpaulee.made_dicoding

import android.content.Intent
import android.os.Bundle
import android.provider.Settings.ACTION_LOCALE_SETTINGS
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.singpaulee.made_dicoding.views.dashboard.DashboardActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast


class HomeActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        home_cv_list.setOnClickListener(this)
        home_cv_favorite.setOnClickListener(this)
        home_cv_setting.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            home_cv_list -> startActivity(intentFor<DashboardActivity>())
            home_cv_favorite -> toast(resources.getString(R.string.string_under_contsruction))
            home_cv_setting -> {
                val mIntent = Intent(ACTION_LOCALE_SETTINGS)
                startActivity(mIntent)
            }
        }
    }
}
