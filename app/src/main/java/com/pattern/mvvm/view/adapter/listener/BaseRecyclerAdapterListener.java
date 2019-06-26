package com.pattern.mvvm.view.adapter.listener;

/**
 * Author: Douglas BR
 * Common method used for all RecyclerView who extends this interface.
 */

public interface BaseRecyclerAdapterListener<T> {
    void onClickItem(T data);
}
