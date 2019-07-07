package com.pattern.mvvm.view.activity

import androidx.lifecycle.ViewModelProviders
import com.pattern.mvvm.BR
import com.pattern.mvvm.R
import com.pattern.mvvm.databinding.ActivityMainBinding
import com.pattern.mvvm.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int = R.layout.activity_main

    override val getViewModel: MainViewModel
        get() {
            mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
            return mViewModel
        }

    override val bindingVariable: Int = BR.main

}
