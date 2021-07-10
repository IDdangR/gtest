package com.example.ntest.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ntest.model.Ndata2
import kotlinx.android.synthetic.main.layout_item2.view.*

class ApiRepositoryItemHolder3(view:View, listener: ApiRepositoryAdapter2.onClickListener?):RecyclerView.ViewHolder(view) {

    private val productTitle: TextView = view.productTitle
    private val reviewCount: TextView = view.reviewCount
    private val imageUrl: ImageView = view.imageUrl

    init {
        view.setOnClickListener {
            listener?.onItemClick(adapterPosition)
        }
    }

    @SuppressLint("SetTextI18n")
    fun bind(model: Ndata2) {
        productTitle.text = model.productTitle
        reviewCount.text = model.reviewCount
        Glide.with(itemView).load(model.imageUrl).into(imageUrl)
    }
}