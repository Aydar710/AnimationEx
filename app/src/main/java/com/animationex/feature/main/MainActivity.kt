package com.animationex.feature.main

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.animationex.BaseViewModelFactory
import com.animationex.R
import com.animationex.data.Item
import com.animationex.data.Repository
import com.animationex.feature.details.DetailsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ItemAdapter

    private var viewAlpha = 1f
    private val alphaDelta = 0.1f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
        initViewModel()
        initObservers()
        viewModel.showItems()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, BaseViewModelFactory {
            MainViewModel(Repository())
        })[MainViewModel::class.java]
    }

    private fun initObservers() {
        viewModel.itemsLiveData.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    private fun initRecycler() {
        adapter = ItemAdapter{item, imageView ->
            onItemClicked(item, imageView)
        }
        rv_main.adapter = adapter

        rv_main.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    if (viewAlpha > 0) {
                        view.alpha = viewAlpha - alphaDelta
                        viewAlpha -= alphaDelta
                    }
                } else {
                    if (viewAlpha < 1) {
                        view.alpha = viewAlpha - alphaDelta
                        viewAlpha += alphaDelta
                    }
                }
            }
        })
    }

    private fun onItemClicked(item: Item, imageView: ImageView) {
        val detailsIntent = Intent(this, DetailsActivity::class.java)
            .apply {
                putExtra("item", item)
            }

        val options = ViewCompat.getTransitionName(imageView)?.let {
            ActivityOptionsCompat
                .makeSceneTransitionAnimation(this, imageView, it)
        }

        startActivity(detailsIntent, options?.toBundle())
    }
}
