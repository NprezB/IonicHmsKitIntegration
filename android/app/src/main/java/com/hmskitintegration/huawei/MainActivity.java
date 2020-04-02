package com.hmskitintegration.huawei;

import android.os.Bundle;

import com.getcapacitor.BridgeActivity;
import com.getcapacitor.Plugin;
import com.hmskitintegration.huawei.plugin.account.HmsAccountPlugin;
import com.hmskitintegration.huawei.plugin.ads.HmsAdsPlugin;
import com.hmskitintegration.huawei.plugin.analytics.HmsAnalyticsPlugin;
import com.hmskitintegration.huawei.plugin.inapppurchase.HmsInAppPurchasePlugin;
import com.hmskitintegration.huawei.plugin.location.HmsLocationPlugin;
import com.hmskitintegration.huawei.plugin.map.HmsMapPlugin;
import com.hmskitintegration.huawei.plugin.push.HmsPushPlugin;

import java.util.ArrayList;

public class MainActivity extends BridgeActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Initializes the Bridge
    this.init(savedInstanceState, new ArrayList<Class<? extends Plugin>>() {{
      // Additional plugins you've installed go here
      // Ex: add(TotallyAwesomePlugin.class);
      add(HmsPushPlugin.class);
      add(HmsAnalyticsPlugin.class);
      add(HmsMapPlugin.class);
      add(HmsAccountPlugin.class);
      add(HmsAdsPlugin.class);
      add(HmsLocationPlugin.class);
      add(HmsInAppPurchasePlugin.class);
    }});
  }
}
