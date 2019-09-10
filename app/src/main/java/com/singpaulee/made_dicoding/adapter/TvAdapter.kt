package com.singpaulee.made_dicoding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.singpaulee.made_dicoding.BuildConfig
import com.singpaulee.made_dicoding.R
import com.singpaulee.made_dicoding.listener.ItemviewAdapterListener
import com.singpaulee.made_dicoding.model.DescriptionTvModel
import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class TvAdapter(val list: ArrayList<DescriptionTvModel>?, val context: Context?,
                private val tvListener: ItemviewAdapterListener.TvListener) :
    RecyclerView.Adapter<TvAdapter.ViewHolder>() {

    lateinit var itemView: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list?.get(position), tvListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            descriptionTvModel: DescriptionTvModel?,
            tvListener: ItemviewAdapterListener.TvListener
        ) {
            Glide.with(itemView.context)
                .load(BuildConfig.BASEURLIMAGE + "${descriptionTvModel?.poster_path}")
                .placeholder(R.drawable.ic_picture_placeholder)
                .error(R.drawable.ic_picture_failed)
                .into(itemView.im_iv_image)

            itemView.im_tv_title.text = descriptionTvModel?.original_name.toString()

            itemView.onClick {
                tvListener.onTvOnClickListener(descriptionTvModel)
            }
        }
    }

}