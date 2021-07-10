package com.example.ntest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.ntest.model.Ndata1
import com.example.ntest.model.Ndata2
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val temp = intent.getSerializableExtra("product")

        if(temp is Ndata1){
            Glide.with(this).load(temp.imageUrl).into(imageUrl)
            productTitle.text = temp.productTitle
        }else if (temp is Ndata2) {
            Glide.with(this).load(temp.imageUrl).into(imageUrl)
            productTitle.text = temp.productTitle
        }



        back.setOnClickListener {
            finish()
        }
    }
}