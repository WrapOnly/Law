package com.handle.law.activity.mine;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;

import com.handle.law.base.BaseActivity;

/**
 * Created by Administrator on 2016/4/26.
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private ImageView ivShare;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.mine_fragment_layout);
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
