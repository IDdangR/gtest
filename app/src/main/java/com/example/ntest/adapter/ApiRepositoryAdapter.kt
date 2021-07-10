package com.example.ntest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ntest.R
import com.example.ntest.model.Ndata1
import com.example.ntest.model.Ndata2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ApiRepositoryAdapter(private var data: List<Ndata1>, private var data2: List<Ndata2>? = null):RecyclerView.Adapter<ApiRepositoryItemHolder>() {

    interface onClickListener {
        fun onItemClick(position: Int)
    }

    var listener: onClickListener? = null

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiRepositoryItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)

        return ApiRepositoryItemHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ApiRepositoryItemHolder, position: Int) {
        holder.bind(data[position])
    }
}