package com.hmskitintegration.huawei;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.hmskitintegration.huawei.driveutils.adapter.TabsAdapter;
import com.hmskitintegration.huawei.driveutils.fragment.InterfaceFragment;
import com.hmskitintegration.huawei.driveutils.log.Logger;
import com.hmskitintegration.huawei.driveutils.model.TabInfo;
import com.hmskitintegration.huawei.driveutils.utils.ViewUtil;
import com.hmskitintegration.huawei.driveutils.view.FileViewPager;

/**
 * Main Activity
 */
public class DriveActivity extends Activity {
    private static final String TAG = "MainActivity";

    public FileViewPager mViewPager;

    public TabsAdapter mTabsAdapter;

    private Toolbar mHwToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive);
        initActionBar();
        initMainView();
    }

    /**
     * Init ActionBar
     */
    protected void initActionBar() {
        mHwToolbar = ViewUtil.findViewById(this, R.id.hwtoolbar);
    }

    /**
     * Init main view
     */
    private void initMainView() {
        mViewPager = findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(1);

        initTabsAdapter();
        setEnableScroll(false);
    }

    /**
     * Init tabs adapter
     */
    private void initTabsAdapter() {
        mTabsAdapter = new TabsAdapter(this, mViewPager, getFragmentManager());
        mTabsAdapter.addTab(InterfaceFragment.class, null);
        mTabsAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (mViewPager == null) {
            Logger.i(TAG, "onOptionsItemSelected viewpager is null");
            return false;
        }
        if (mTabsAdapter == null) {
            Logger.i(TAG, "onOptionsItemSelected mTabsAdapter is null");
            return false;
        }
        int currentItem = mViewPager.getCurrentItem();
        TabInfo tabInfo = mTabsAdapter.getTabInfo(currentItem);
        Fragment fragment = tabInfo.getFragment();

        if (fragment == null) {
            Logger.i(TAG, "onOptionsItemSelected fragment is null");
            return false;
        }

        return true;
    }

    /**
     * Set enableScroll
     */
    public void setEnableScroll(boolean enableScroll) {
        if (mViewPager != null) {
            mViewPager.setEnableScroll(enableScroll);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public Toolbar getToolbar() {
        return mHwToolbar;
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mTabsAdapter == null || null == mViewPager) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}