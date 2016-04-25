package com.handle.law.activity.mine;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.handle.law.R;
import com.handle.law.base.BaseActivity;
import com.handle.law.component.togglebutton.ToggleButton;

/**
 * Created by Administrator on 2016/4/26.
 */
public class SetMessageNotifyActivity extends BaseActivity {

    private ToggleButton messageDetailToggleBtn;
    private ToggleButton soundToggleBtn;
    private ToggleButton vibrateToggleBtn;
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
        this.messageDetailToggleBtn = (ToggleButton) findViewById(R.id.tb_message_detail);
        this.soundToggleBtn         = (ToggleButton) findViewById(R.id.tb_is_sound);
        this.vibrateToggleBtn       = (ToggleButton) findViewById(R.id.tb_is_vibrate);
        this.imageUpdateToggleBtn   = (ToggleButton) findViewById(R.id.tb_is_update_image);
    }

    @Override
    protected void setListener() {
        this.messageDetailToggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean isChecked) {

            }
        });
        this.soundToggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean isChecked) {

            }
        });
        this.vibrateToggleBtn.setOnToggleChanged(new ToggleButton.OnToggleChanged() {
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
