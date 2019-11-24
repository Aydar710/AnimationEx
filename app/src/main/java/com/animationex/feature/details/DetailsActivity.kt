package com.animationex.feature.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.animationex.R
import com.animationex.data.Item
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val item = intent.getSerializableExtra("item") as Item

        iv_item.setImageResource(item.image)
        tv_title.text = item.title
    }
}
