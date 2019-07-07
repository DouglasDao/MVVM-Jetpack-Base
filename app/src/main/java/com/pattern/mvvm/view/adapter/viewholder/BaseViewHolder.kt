package com.pattern.mvvm.view.adapter.viewholder

import android.content.Context
import android.view.View

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Author: Douglas BR
 * Common Abstract template class for ViewHolder.
 */

abstract class BaseViewHolder<T, DB : ViewDataBinding> : RecyclerView.ViewHolder {

    internal var data: T? = null
    internal lateinit var binding: DB
    internal lateinit var mContext: Context
    internal var TAG = javaClass.simpleName

    internal constructor(itemView: View) : super(itemView) {}

    internal constructor(itemView: View, binding: DB) : super(itemView) {
        this.binding = binding
        mContext = binding.root.context
    }

    fun setData(data: T) {
        this.data = data
        populateData()
    }

    internal abstract fun populateData()
}