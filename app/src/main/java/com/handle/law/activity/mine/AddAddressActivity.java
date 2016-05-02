package com.handle.law.activity.mine;

import android.os.Bundle;
import android.view.View;

import com.handle.law.R;
import com.handle.law.base.BaseActivity;

/**
 * Created by Administrator on 2016/4/26.
 */
public class AddAddressActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_add_address_activity);
        this.initViews();
        this.setListener();
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
