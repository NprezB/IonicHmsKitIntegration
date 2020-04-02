package com.hmskitintegration.huawei.adsutils;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.hmskitintegration.huawei.R;
import com.hmskitintegration.huawei.adsutils.dialogs.ProtocolDialog;

public class ProtocolActivity extends AppCompatActivity implements ProtocolDialog.ProtocolDialogCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.privacy_settings));

        showProtocolDialog();
    }

    /**
     * Display a protocol dialog.
     */
    private void showProtocolDialog() {
        // Start to process the protocol dialog box.
        ProtocolDialog dialog = new ProtocolDialog(this);
        dialog.setCallback(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    @Override
    public void agree() {
        finish();
    }

    @Override
    public void cancel() {
        finish();
    }
}