package com.pattern.mvvm.view.adapter.listener

/**
 * Author: Douglas BR
 * Common method used for all RecyclerView who extends this interface.
 */

interface BaseRecyclerAdapterListener<T> {
    fun onClickItem(data: T)
}
