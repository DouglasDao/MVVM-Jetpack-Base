package com.pattern.mvvm.view.activity;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProviders;
import com.pattern.mvvm.BR;
import com.pattern.mvvm.R;
import com.pattern.mvvm.databinding.ActivityMainBinding;
import com.pattern.mvvm.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    MainViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        return mViewModel;
    }

    @Override
    int getBindingVariable() {
        return BR.main;
    }
}
