package com.example.ntest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ntest.R
import com.example.ntest.model.Ndata1
import com.example.ntest.model.Ndata2
import com.example.ntest.model.Ndata2s
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ApiRepositoryAdapter2(private var data: List<Ndata2>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface onClickListener {
        fun onItemClick(position: Int)
    }

    var listener: onClickListener? = null

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item2, parent, false)
        return ApiRepositoryItemHolder3(view, listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       (holder as ApiRepositoryItemHolder3).bind(data[position])
    }
}