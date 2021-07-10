package com.example.ntest.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ntest.DetailActivity
import com.example.ntest.model.Ndata1
import com.example.ntest.model.Ndata2
import kotlinx.android.synthetic.main.view.view.*
import kotlin.coroutines.coroutineContext

class ApiRepositoryItemHolder2(view:View, context:Context):RecyclerView.ViewHolder(view) {

    private lateinit var mAdapter: ApiRepositoryAdapter2
    private val context = context

    init {
    }

    @SuppressLint("SetTextI18n")
    fun bind(model: List<Ndata2>) {
        mAdapter = model.let {
            ApiRepositoryAdapter2(it).apply {
                listener = object : ApiRepositoryAdapter2.onClickListener {
                    override fun onItemClick(position: Int) {
                        Intent(context, DetailActivity::class.java).let {
                            it.putExtra("product", model[position])
                            context.startActivity(it)
                        }
                    }
                }
            }
        }!!

        itemView.list.run {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter
        }
    }
}