package com.handle.law.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.handle.law.R;
import com.handle.law.base.BaseActivity;

/**
 * Created by Administrator on 2016/4/26.
 */
public class FeedBackActivity extends BaseActivity implements View.OnClickListener{

    private ImageView ivBack;
    private TextView  tvSendFeedBack;
    private EditText  etFeedBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_back_activity);
        this.initViews();
        this.setListener();
    }

    @Override
    protected void initViews() {
        ivBack          = (ImageView) findViewById(R.id.iv_back);
        tvSendFeedBack  = (TextView) findViewById(R.id.tv_send_feed_back);
        etFeedBack      = (EditText) findViewById(R.id.et_feed_back);
    }

    @Override
    protected void setListener() {
        ivBack.setOnClickListener(this);
        tvSendFeedBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                break;
            case R.id.tv_send_feed_back:
                break;
        }
    }
}
