package com.handle.law.activity.mine;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.handle.law.R;
import com.handle.law.base.BaseActivity;
import com.handle.law.component.togglebutton.ToggleButton;

/**
 * Created by Administrator on 2016/4/26.
 */
public class PrivateInfoActivity extends BaseActivity {

    private ToggleButton addMeVerifyToggleBtn;
    private ToggleButton searchToggleBtn;
    private ToggleButton imageUpdateToggleBtn;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.set_message_notify_activity);
        this.initViews();
        this.setListener();
    }

    @Override
    protected void initViews() {
        this.addMeVerifyToggleBtn   = (ToggleButton) findViewById(R.id.tb_message_detail);
        this.searchToggleBtn        = (ToggleButton) findViewById(R.id.tb_is_sound);
        this.imageUpdateToggleBtn   = (ToggleButton) findViewById(R.id.tb_is_update_image);
    }

    @Override
    protected void setListener() {
        this.addMeVerifyToggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean isChecked) {

            }
        });
        this.searchToggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean isChecked) {

            }
        });
        this.imageUpdateToggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean isChecked) {

            }
        });
    }
}
