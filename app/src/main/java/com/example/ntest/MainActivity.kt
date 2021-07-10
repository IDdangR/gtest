package com.example.ntest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ntest.adapter.ApiRepositoryAdapter
import com.example.ntest.model.Ndata1
import com.example.ntest.model.Ndatas
import com.example.ntest.netservice.ApiRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var mAdapter: ApiRepositoryAdapter

    private var page = 1
    private var listData = ArrayList<Ndata1>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelFactory = MainViewModelFactory(ApiRepository())
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.nData.observe(this) {
            updateData(it)
            mAdapter.notifyDataSetChanged()
        }

        viewModel.requestApi(page)
    }

    private fun updateData(data: Ndatas) {
        for(temp in data.products!!) {
            listData.add(temp)
        }

        if(::mAdapter.isInitialized){

        } else {
            mAdapter =  ApiRepositoryAdapter(listData).apply {
                listener = object : ApiRepositoryAdapter.onClickListener {
                    override fun onItemClick(position: Int) {
                        Intent(this@MainActivity, DetailActivity::class.java).let {
                            it.putExtra("product", listData[position])
                            startActivity(it)
                        }
                    }
                }
            }

            list.run {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = mAdapter
                addItemDecoration(DividerItemDecoration(context, 1))
                addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        super.onScrolled(recyclerView, dx, dy)

                        if (!list.canScrollVertically(-1)) {
                            // 스크롤 맨 위 감지

                        } else if (!list.canScrollVertically(1)) {
                            // 스크롤 맨 밑 감지
                            page++
                            if(page > 3) page = 1
                            viewModel.requestApi(page)
                        } else {
                            // 그 외
                        }
                    }
                })
            }
        }
    }
}