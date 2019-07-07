package com.pattern.mvvm.view.adapter


import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.pattern.mvvm.view.adapter.viewholder.BaseViewHolder
import java.util.*

/**
 * Author: Douglas BR
 * Common Abstract template class for BaseRecyclerView Adapter.
 */

internal abstract class BaseRecyclerAdapter<T, DB : ViewDataBinding, VH : BaseViewHolder<T, DB>>(private var data: MutableList<T>?) : RecyclerView.Adapter<VH>() {

    protected var TAG = javaClass.simpleName
    protected var binding: DB? = null


    override fun onBindViewHolder(holder: VH, position: Int) {
        // Enable this when adding adapters
        //        binding.setVariable(BR.holder, holder);
        binding!!.executePendingBindings()
        holder.setData(getItem(position))

    }


    override fun getItemCount(): Int {
        return data!!.size
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getItem(position: Int): T {
        return data!![position]
    }

    fun addItem(`object`: T) {
        data!!.add(`object`)
        notifyItemInserted(data!!.indexOf(`object`))
    }

    @Throws(IndexOutOfBoundsException::class)
    fun removeItem(position: Int) {
        data!!.removeAt(position)
        notifyItemRemoved(position)
    }

    fun resetItems(data: MutableList<T>?, position: Int) {
        if (data != null) {
            this.data = data
            notifyItemChanged(position, data.size)
        }
    }

    fun resetItems(data: MutableList<T>?) {
        if (data != null) {
            this.data = data
            notifyDataSetChanged()
        }
    }

    fun setData(position: Int, data: T?) {
        if (data != null) {
            this.data!![position] = data
            notifyItemChanged(position)
        }
    }

    fun addItems(data: List<T>?) {
        if (data != null) {
            val startRange = if (this.data!!.size - 1 > 0) data.size - 1 else 0
            this.data!!.addAll(data)
            notifyItemRangeChanged(startRange, data.size)
        }
    }

    fun getData(): List<T>? {
        return data
    }

    fun setFilter(data: MutableList<T>) {
        this.data = ArrayList()
        this.data!!.addAll(data)
        resetItems(data)
    }


}
