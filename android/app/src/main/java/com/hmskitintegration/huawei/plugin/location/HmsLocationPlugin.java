package com.hmskitintegration.huawei.plugin.location;

import android.content.Intent;

import com.hmskitintegration.huawei.LocationActivity;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin()
public class HmsLocationPlugin extends Plugin {

    private static final String TAG = "CustomAdsPlugin";

    @PluginMethod()
    public void jump2LocationActivity(PluginCall call) {
        Intent intent = new Intent(getActivity(), LocationActivity.class);
        getActivity().startActivity(intent);
        call.resolve();
    }

}
