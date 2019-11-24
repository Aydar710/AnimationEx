package com.animationex.feature.main

import androidx.recyclerview.widget.DiffUtil
import com.animationex.data.Item

class ItemDiffCallback :  DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean  = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean  = oldItem == newItem
}