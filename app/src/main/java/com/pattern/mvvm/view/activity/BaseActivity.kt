package com.pattern.mvvm.view.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<DB : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    internal lateinit var binding: DB
    internal lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        binding = DataBindingUtil.setContentView(this, layoutId)

        /**
         * Common Place for Activity's View Model Object Creation (Registration)
         */

        this.mViewModel = getViewModel
        binding.lifecycleOwner = this

        /**
         * One Binding Variable for Each XML Layout
         */

        binding.setVariable(bindingVariable, mViewModel)
        binding.executePendingBindings()
    }

    internal abstract val layoutId: Int
    internal abstract val getViewModel: VM
    internal abstract val bindingVariable: Int
}
