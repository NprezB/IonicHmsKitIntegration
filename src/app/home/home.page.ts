import { Component } from '@angular/core';
import { Plugins } from '@capacitor/core';

const { HmsPushPlugin, HmsSitePlugin, HmsAnalyticsPlugin, HmsMapPlugin } = Plugins;
const { HmsAccountPlugin } = Plugins;
const { HmsAdsPlugin } = Plugins;
const { HmsLocationPlugin } = Plugins;
const { HmsInAppPurchasePlugin } = Plugins;
const { HmsDrivePlugin } = Plugins;


@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor() { }

  getPushToken() {
    HmsPushPlugin.getToken();
  }

  logEvent(name: string, bundle: object) {
    const param = {eventName: name, bundle: JSON.stringify(bundle)}
    HmsAnalyticsPlugin.logEvent(param);
  }

  triggerMap() {
    HmsMapPlugin.jump2MapActivity();
  }

  triggerAccount() {
    HmsAccountPlugin.jump2AccountActivity();
  }

  triggerAds() {
    HmsAdsPlugin.jump2AdsActivity();
  }

  triggerLocation() {
    HmsLocationPlugin.jump2LocationActivity();
  }

  triggerPurchase() {
    HmsInAppPurchasePlugin.jump2PurchaseActivity();
  }

  triggerDrive() {
    HmsDrivePlugin.jump2DriveActivity();
  }

  triggerSite() {
    HmsSitePlugin.jump2SiteActivity();
  }
}
