package com.hmskitintegration.huawei.plugin.inapppurchase;

import android.content.Intent;

import com.hmskitintegration.huawei.InAppPurchaseActivity;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin
public class HmsInAppPurchasePlugin extends Plugin {

        private static final String TAG = "CustomInAppPurchasePlugin";

        @PluginMethod()
        public void jump2PurchaseActivity(PluginCall call) {
            Intent intent = new Intent(getActivity(), InAppPurchaseActivity.class);
            getActivity().startActivity(intent);
            call.resolve();
        }

}