package com.handle.law.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.handle.law.R;
import com.handle.law.base.BaseActivity;
import com.handle.law.component.togglebutton.ToggleButton;

/**
 * Created by Administrator on 2016/4/26.
 */
public class PrivateInfoActivity extends BaseActivity {

    //返回键
    private ImageView       ivBackView;
    //加我时需要验证
    private ToggleButton    addMeVerifyToggleBtn;
    //不让其他人看我
    private ToggleButton    limitOhterSeeMeToggleBtn;
    //动态图片更新
    private ToggleButton    imageUpdateToggleBtn;
    //不看他人的
    private RelativeLayout  rlNotSeeOtherDynamic;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_private_info_activity);
        this.initViews();
        this.setListener();
    }

    @Override
    protected void initViews() {
        this.ivBackView             = (ImageView) findViewById(R.id.iv_back);
        this.addMeVerifyToggleBtn   = (ToggleButton) findViewById(R.id.tb_message_detail);
        this.limitOhterSeeMeToggleBtn = (ToggleButton) findViewById(R.id.tb_is_limit_other);
        this.imageUpdateToggleBtn   = (ToggleButton) findViewById(R.id.tb_is_show_dynamic_image_update);
        this.rlNotSeeOtherDynamic   = (RelativeLayout) findViewById(R.id.rl_limit_not_see_other);
    }

    @Override
    protected void setListener() {
        this.ivBackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PrivateInfoActivity.this.onBackPressed();
            }
        });
        this.addMeVerifyToggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean isChecked) {

            }
        });
        this.limitOhterSeeMeToggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean isChecked) {

            }
        });
        this.imageUpdateToggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean isChecked) {

            }
        });
        this.rlNotSeeOtherDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
}
