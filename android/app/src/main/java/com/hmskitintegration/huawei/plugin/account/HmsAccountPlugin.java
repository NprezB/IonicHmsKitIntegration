package com.hmskitintegration.huawei.plugin.account;

import android.content.Intent;

import com.hmskitintegration.huawei.AccountActivity;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;


@NativePlugin()
public class HmsAccountPlugin extends Plugin {

    private static final String TAG = "CustomAccountPlugin";

    @PluginMethod()
    public void jump2AccountActivity(PluginCall call) {
        Intent intent = new Intent(getActivity(), AccountActivity.class);
        getActivity().startActivity(intent);
        call.resolve();
    }

}
