package com.hmskitintegration.huawei.locationutils;

import android.app.FragmentTransaction;

import com.hmskitintegration.huawei.R;
import com.hmskitintegration.huawei.logger.LoggerActivity;

public class BaseActivity extends LoggerActivity
{
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void addLogFragment() {
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        final LogFragment fragment = new LogFragment();
        transaction.replace(R.id.framelog, fragment);
        transaction.commit();
    }
}
