package com.animationex.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.animationex.data.Item
import com.animationex.data.Repository

class MainViewModel(private val repo: Repository) : ViewModel() {

    private val _itemsLiveData = MutableLiveData<List<Item>>()

    val itemsLiveData: LiveData<List<Item>>
        get() = _itemsLiveData

    fun showItems() {
        val items = repo.getItems()
        _itemsLiveData.postValue(items)
    }
}