package com.hmskitintegration.huawei.plugin.site;

import android.content.Intent;

import com.hmskitintegration.huawei.SiteActivity;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin()
public class HmsSitePlugin extends Plugin {

    private static final String TAG = "CustomSitePlugin";

    @PluginMethod()
    public void jump2SiteActivity(PluginCall call) {
        Intent intent = new Intent(getActivity(), SiteActivity.class);
        getActivity().startActivity(intent);
        call.resolve();
    }
}
