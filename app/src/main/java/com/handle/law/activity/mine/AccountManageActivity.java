package com.handle.law.activity.mine;

import android.os.Bundle;
import android.view.View;

import com.handle.law.R;
import com.handle.law.base.BaseActivity;

/**
 * Created by Administrator on 2016/4/26.
 */
public class AccountManageActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_back_activity);
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
        finish();
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
}
