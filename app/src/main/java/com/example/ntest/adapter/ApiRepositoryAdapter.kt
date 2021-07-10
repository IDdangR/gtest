package com.example.ntest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ntest.R
import com.example.ntest.model.Ndata1
import com.example.ntest.model.Ndata2

class ApiRepositoryAdapter(private var data: List<*>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_gen = 0
        private const val TYPE_rec = 1
    }

    interface onClickListener {
        fun onItemClick(position: Int)
    }

    var listener: onClickListener? = null

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_rec -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
                ApiRepositoryItemHolder2(view, parent.context)
            }
            else ->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
                ApiRepositoryItemHolder(view, listener)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ApiRepositoryItemHolder) {
            holder.bind(data[position] as Ndata1)
        }
        else {
            (holder as ApiRepositoryItemHolder2).bind(data[position] as List<Ndata2>)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            10, 21, 32 -> TYPE_rec
            else -> TYPE_gen
        }
    }
}