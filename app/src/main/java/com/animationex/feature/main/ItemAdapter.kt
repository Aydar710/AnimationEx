package com.animationex.feature.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.animationex.R
import com.animationex.data.Item
import kotlinx.android.synthetic.main.item_main.view.*

class ItemAdapter(
    private val clickListener: (Item, ImageView) -> Unit
) : ListAdapter<Item, ItemAdapter.ItemViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Item) {
            itemView.iv_item.setImageResource(item.image)
            itemView.tv_title.text = item.title

            itemView.setOnClickListener {
                clickListener.invoke(item, itemView.iv_item)
            }
        }

    }
}