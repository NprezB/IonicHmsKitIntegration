package com.hmskitintegration.huawei.plugin.map;

import android.content.Intent;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.hmskitintegration.huawei.MapsActivity;

@NativePlugin()
public class HmsMapPlugin extends Plugin {

    private static final String TAG = "CustomMapPlugin";

    @PluginMethod()
    public void customCall(PluginCall call) {
        String message = call.getString("message");
        Log.d(TAG, "CustomMapPlugin message is " + message);
        JSObject ret = new JSObject();
        ret.put("value", message);
        // More code here...
        call.success(ret);
    }

    @PluginMethod()
    public void jump2MapActivity(PluginCall call) {
        Intent intent = new Intent(getActivity(), MapsActivity.class);
        getActivity().startActivity(intent);
        call.resolve();
    }
}