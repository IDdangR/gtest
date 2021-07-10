package com.example.ntest.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.circleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.ntest.R
import com.example.ntest.model.Ndata1
import kotlinx.android.synthetic.main.layout_item.view.*

class ApiRepositoryItemHolder(view:View, listener: ApiRepositoryAdapter.onClickListener?):RecyclerView.ViewHolder(view) {

    private val productTitle: TextView = view.productTitle
    private val brandTitle: TextView = view.brandTitle
    private val ratingAvg: TextView = view.ratingAvg
    private val productRank: TextView = view.productRank
    private val imageUrl: ImageView = view.imageUrl

    init {
        view.setOnClickListener {
            listener?.onItemClick(adapterPosition)
        }
    }

    @SuppressLint("SetTextI18n")
    fun bind(model: Ndata1) {
        productRank.text = model.productRank
        brandTitle.text = model.brand?.brandTitle ?: ""
        productTitle.text = model.productTitle
        ratingAvg.text = model.ratingAvg.toString()
        Glide.with(itemView).load(model.imageUrl).into(imageUrl)
    }
}