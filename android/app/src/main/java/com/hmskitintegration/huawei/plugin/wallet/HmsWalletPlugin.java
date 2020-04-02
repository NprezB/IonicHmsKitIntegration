package com.hmskitintegration.huawei.plugin.wallet;

import android.content.Intent;

import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.hmskitintegration.huawei.MapsActivity;

@NativePlugin()
public class HmsWalletPlugin extends Plugin {

    private static final String TAG = "CustomSitePlugin";

    @PluginMethod()
    public void jump2SiteActivity(PluginCall call) {
        Intent intent = new Intent(getActivity(), MapsActivity.class);
        getActivity().startActivity(intent);
        call.resolve();
    }
}
