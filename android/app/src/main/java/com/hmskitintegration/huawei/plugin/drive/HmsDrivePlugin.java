package com.hmskitintegration.huawei.plugin.drive;

import android.content.Intent;

import com.hmskitintegration.huawei.DriveActivity;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin
public class HmsDrivePlugin extends Plugin {

    private static final String TAG = "CustomDrivePlugin";

    @PluginMethod()
    public void jump2DriveActivity(PluginCall call) {
        Intent intent = new Intent(getActivity(), DriveActivity.class);
        getActivity().startActivity(intent);
        call.resolve();
    }
}
