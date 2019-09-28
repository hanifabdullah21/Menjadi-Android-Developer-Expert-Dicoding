package com.singpaulee.made_dicoding.views.detailtv

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.singpaulee.made_dicoding.BuildConfig
import com.singpaulee.made_dicoding.R
import com.singpaulee.made_dicoding.bank.ConstantTemplate
import com.singpaulee.made_dicoding.helper.HelperClass
import com.singpaulee.made_dicoding.model.DescriptionTvModel
import kotlinx.android.synthetic.main.activity_detail_tv.*
import kotlinx.android.synthetic.main.view_information.*
import org.jetbrains.anko.toast
import java.util.*

class DetailTvActivity : AppCompatActivity(), DetailTvView {

    var presenter: DetailTvPresenter? = null
    var tv: DescriptionTvModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)

        //init
        presenter = DetailTvPresenter()
        tv = intent.getParcelableExtra(ConstantTemplate.ARG_TV)

        onAttachView()

        val language = Locale.getDefault().language
        presenter?.getDetailTv(tv?.id, language)

        setDetailTv()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showErrorMessage(message: String?) {
        toast("Error because $message")
        Log.e("DETAILTV", message)
    }

    override fun onShowDetailTv(detailTvModel: DescriptionTvModel?) {
        tv = detailTvModel
        setDetailTv()
    }

    override fun onAttachView() {
        presenter?.onAttach(this)
    }

    override fun onDetachView() {
        presenter?.onDetach()
    }

    @SuppressLint("SetTextI18n")
    private fun setDetailTv() {
        Glide.with(this)
            .load(BuildConfig.BASEURLIMAGE + "${tv?.poster_path}")
            .placeholder(R.drawable.ic_picture_placeholder)
            .error(R.drawable.ic_picture_failed)
            .into(dtva_iv_poster)

        val backdrop = tv?.backdrop_path ?: tv?.poster_path
        Glide.with(this)
            .load(BuildConfig.BASEURLIMAGE + "$backdrop")
            .placeholder(R.drawable.ic_picture_placeholder)
            .error(R.drawable.ic_picture_failed)
            .into(dtva_iv_backdrop)

        dtva_tv_title.text = tv?.original_name
        dtva_tv_year.text = HelperClass.getYearFromDate(tv?.first_air_date.toString())
        dtva_tv_overview.text =
            if (tv?.overview == null || tv?.overview == "") resources.getString(R.string.string_overview_tv_has_not_exist) else tv?.overview

        vi_tv_rating.text = tv?.vote_average.toString()
        vi_tv_popularity.text =
            if (tv?.popularity == null) "-" else String.format("%.1f", tv?.popularity)
        vi_tv_voted.text =
            if (tv?.vote_count == null) "-" else tv?.vote_count.toString()

        tv?.last_episode_to_air?.let {
            dtva_tv_last_airing_not_exist.visibility = View.GONE
            dtva_tv_episode_last_airing.text =
                resources.getString(R.string.string_dtva_episode) + " ${tv?.last_episode_to_air?.episode_number}"
            dtva_tv_date_last_airing.text =
                HelperClass.convertDateYmdToDmy(tv?.last_episode_to_air?.air_date)
            dtva_tv_overview_last_airing.text =
                if (tv?.last_episode_to_air?.overview == null || tv?.last_episode_to_air?.overview == "")
                    resources?.getString(R.string.string_overview_episode_tv_has_not_exist)
                else tv?.last_episode_to_air?.overview

            Glide.with(this)
                .load(BuildConfig.BASEURLIMAGE + "${tv?.last_episode_to_air?.still_path}")
                .placeholder(R.drawable.ic_picture_placeholder)
                .error(R.drawable.ic_picture_failed)
                .into(dtva_iv_poster_last_airing)
        }.run {
            dtva_tv_last_airing_not_exist.visibility = View.VISIBLE
            dtva_iv_poster_last_airing.visibility = View.GONE
            dtva_tv_episode_last_airing.visibility = View.GONE
            dtva_tv_date_last_airing.visibility = View.GONE
            dtva_tv_overview_last_airing.visibility = View.GONE
        }

        tv?.next_episode_to_air?.let {
            dtva_tv_next_airing_not_exist.visibility = View.GONE
            dtva_tv_episode_next_airing.text =
                resources.getString(R.string.string_dtva_episode) + " ${tv?.next_episode_to_air?.episode_number}"
            dtva_tv_date_next_airing.text =
                HelperClass.convertDateYmdToDmy(tv?.next_episode_to_air?.air_date)
            dtva_tv_overview_next_airing.text =
                if (tv?.next_episode_to_air?.overview == null || tv?.next_episode_to_air?.overview == "")
                    resources?.getString(R.string.string_overview_episode_tv_has_not_exist)
                else tv?.next_episode_to_air?.overview

            Glide.with(this)
                .load(BuildConfig.BASEURLIMAGE + "${tv?.next_episode_to_air?.still_path}")
                .placeholder(R.drawable.ic_picture_placeholder)
                .error(R.drawable.ic_picture_failed)
                .into(dtva_iv_poster_next_airing)
        }.run {
            dtva_tv_next_airing_not_exist.visibility = View.VISIBLE
            dtva_iv_poster_next_airing.visibility = View.GONE
            dtva_tv_episode_next_airing.visibility = View.GONE
            dtva_tv_date_next_airing.visibility = View.GONE
            dtva_tv_overview_next_airing.visibility = View.GONE
        }
    }
}
