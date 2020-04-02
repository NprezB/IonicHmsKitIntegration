package com.hmskitintegration.huawei.plugin.ads;

import android.content.Intent;

import com.hmskitintegration.huawei.AdsActivity;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin()
public class HmsAdsPlugin extends Plugin {

    private static final String TAG = "CustomAdsPlugin";

    @PluginMethod()
    public void jump2AdsActivity(PluginCall call) {
        Intent intent = new Intent(getActivity(), AdsActivity.class);
        getActivity().startActivity(intent);
        call.resolve();
    }

}
