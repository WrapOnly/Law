package com.handle.law.activity.mine;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.handle.law.R;
import com.handle.law.base.BaseActivity;

/**
 * Created by Administrator on 2016/4/26.
 */
public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ivBack;
    private ImageView ivShare;
    private ImageView ivAvatar;
    private RelativeLayout rlAccountManageLayout;
    private RelativeLayout rlNewMessageNotifyLayout;
    private RelativeLayout rlPrivateInfoLayout;
    private RelativeLayout rlLogoutLayout;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.mine_setting_activity);
        this.initViews();
        this.setListener();
    }

    @Override
    protected void initViews() {
        this.ivBack = (ImageView) findViewById(R.id.iv_back);
        this.ivShare = (ImageView) findViewById(R.id.iv_my_share);
        this.ivAvatar = (ImageView) findViewById(R.id.iv_head);
        this.rlAccountManageLayout = (RelativeLayout) findViewById(R.id.rl_account_manage);
        this.rlNewMessageNotifyLayout = (RelativeLayout) findViewById(R.id.rl_new_message);
        this.rlPrivateInfoLayout = (RelativeLayout) findViewById(R.id.rl_yinsi);
        this.rlLogoutLayout = (RelativeLayout) findViewById(R.id.rl_log_out);
    }

    @Override
    protected void setListener() {
        this.ivBack.setOnClickListener(this);
        this.ivShare.setOnClickListener(this);
        this.ivAvatar.setOnClickListener(this);
        this.rlAccountManageLayout.setOnClickListener(this);
        this.rlNewMessageNotifyLayout.setOnClickListener(this);
        this.rlPrivateInfoLayout.setOnClickListener(this);
        this.rlLogoutLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                break;
            case R.id.iv_my_share:
                break;
            case R.id.iv_head:
                break;
            case R.id.rl_account_manage:
                break;
            case R.id.rl_new_message:
                break;
            case R.id.rl_yinsi:
                break;
            case R.id.rl_log_out:
                break;
        }
    }
}
