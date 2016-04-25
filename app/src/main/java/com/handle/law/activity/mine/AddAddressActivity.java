package com.handle.law.activity.mine;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.handle.law.R;
import com.handle.law.base.BaseActivity;

/**
 * Created by Administrator on 2016/4/26.
 */
public class AddAddressActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
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
}
