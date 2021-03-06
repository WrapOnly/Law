package com.handle.law.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.handle.law.R;
import com.handle.law.base.BaseActivity;
import com.handle.law.dao.CityDao;

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
    private RelativeLayout rlFeedBackLayout;
    private RelativeLayout rlLogoutLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        this.rlFeedBackLayout = (RelativeLayout) findViewById(R.id.rl_feed_back);
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
        this.rlFeedBackLayout.setOnClickListener(this);
        this.rlLogoutLayout.setOnClickListener(this);
//        Object[] address =  CityDao.queryProvince();
//        Toast.makeText(this, CityDao.queryProvince()[0].toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                this.onBackPressed();
                break;
            //分享
            case R.id.iv_my_share:
                break;
            case R.id.iv_head:
                break;
            case R.id.rl_account_manage:
                Intent accountManageIntent = new Intent(this, AccountManageActivity.class);
                startActivity(accountManageIntent);
                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
                break;
            case R.id.rl_new_message:
                Intent setMsgNotifyIntent = new Intent(this, SetMessageNotifyActivity.class);
                startActivity(setMsgNotifyIntent);
                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
                break;
            case R.id.rl_yinsi://去隐私界面
                Intent privateInfoIntent = new Intent(this, PrivateInfoActivity.class);
                startActivity(privateInfoIntent);
                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
                break;
            case R.id.rl_feed_back://意见反馈
                Intent feedBackInent = new Intent(this, FeedBackActivity.class);
                startActivity(feedBackInent);
                overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
                break;
            case R.id.rl_log_out:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
}
