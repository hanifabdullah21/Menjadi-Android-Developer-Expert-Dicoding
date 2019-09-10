package com.singpaulee.made_dicoding.views.fragmentmovie


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.singpaulee.made_dicoding.R
import com.singpaulee.made_dicoding.adapter.MoviesAdapter
import com.singpaulee.made_dicoding.adapter.TvAdapter
import com.singpaulee.made_dicoding.bank.ConstantTemplate
import com.singpaulee.made_dicoding.listener.ItemviewAdapterListener
import com.singpaulee.made_dicoding.model.DescriptionMovieModel
import com.singpaulee.made_dicoding.model.DescriptionTvModel
import com.singpaulee.made_dicoding.views.detailmovie.DetailMovieActivity
import com.singpaulee.made_dicoding.views.detailtv.DetailTvActivity
import kotlinx.android.synthetic.main.fragment_movie.view.*
import kotlinx.android.synthetic.main.view_error.view.*
import org.jetbrains.anko.support.v4.intentFor

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment(), ListMovieView, View.OnClickListener,
    ItemviewAdapterListener.MovieListener, ItemviewAdapterListener.TvListener {

    lateinit var rootView: View

    var presenter: ListMoviePresenter? = null
    private var type: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_movie, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ListMoviePresenter()
        onAttachView()

        type = arguments?.getString(ConstantTemplate.ARG_KEY_MOVIE)
        presenter?.getListMovieOrTvShow(type)

        rootView.ve_btn_try_again.setOnClickListener(this)
    }

    override fun onShowListMovie(listMovie: ArrayList<DescriptionMovieModel>?) {
        val lm = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val adapter = MoviesAdapter(listMovie, activity, this)
        rootView.mf_recyclerview.layoutManager = lm
        rootView.mf_recyclerview.adapter = adapter
    }

    override fun onShowListTv(listTv: ArrayList<DescriptionTvModel>?) {
        val lm = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val adapter = TvAdapter(listTv, activity, this)
        rootView.mf_recyclerview.layoutManager = lm
        rootView.mf_recyclerview.adapter = adapter
        Log.d("TVSHOW", listTv.toString())
    }

    override fun showLoading() {
        rootView.mf_recyclerview.visibility = View.GONE
        rootView.mf_lottie_loading.visibility = View.VISIBLE
        rootView.mf_view_error.visibility = View.GONE
    }

    override fun hideLoading() {
        rootView.mf_lottie_loading.visibility = View.GONE
        rootView.mf_recyclerview.visibility = View.VISIBLE
        rootView.mf_view_error.visibility = View.GONE
    }

    override fun showErrorMessage(message: String?) {
        rootView.mf_lottie_loading.visibility = View.GONE
        rootView.mf_recyclerview.visibility = View.GONE
        rootView.mf_view_error.visibility = View.VISIBLE

        rootView.ve_tv_error_message.text = message
    }

    override fun onAttachView() {
        presenter?.onAttach(this)
    }

    override fun onDetachView() {
        presenter?.onDetach()
    }

    override fun onClick(v: View?) {
        when (v) {
            rootView.ve_btn_try_again -> presenter?.getListMovieOrTvShow(type)
        }
    }

    override fun onMovieOnClickListener(model: DescriptionMovieModel?) {
        startActivity(intentFor<DetailMovieActivity>(ConstantTemplate.ARG_MOVIE to model))
    }

    override fun onTvOnClickListener(model: DescriptionTvModel?) {
        startActivity(intentFor<DetailTvActivity>(ConstantTemplate.ARG_TV to model))
    }
}
