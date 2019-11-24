package com.animationex.data

import com.animationex.R


class Repository {

    fun getItems(): MutableList<Item> {
        val items = mutableListOf<Item>()

        for (i in 0..5) {
            items.add(Item(i, "title $i", R.drawable.image1))
        }

        for (i in 6..10) {
            items.add(Item(i, "title $i", R.drawable.image2))
        }

        for (i in 11..15) {
            items.add(Item(i, "title $i", R.drawable.image3))
        }

        items.shuffle()
        return items
    }
}