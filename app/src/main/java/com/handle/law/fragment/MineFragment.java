package com.handle.law.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.handle.law.R;
import com.handle.law.base.BaseFragment;

/**
 * Created by Administrator on 2016/4/25.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener{

    private LinearLayout linearAccountLayout;

    private RelativeLayout rlMyWrokRecordLayout;
    private RelativeLayout rlMyServiceLayout;
    private RelativeLayout rlMyNeedLayout;

    private RelativeLayout rlMyPhoneLayout;
    private RelativeLayout rlMyAddressLayout;

    private ImageView ivAvatar;
    private TextView tvAccountName;
    private TextView tvInfoDetail;

    private TextView tvPhone;
    private TextView tvAddress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment_layout, container, false);
        this.initViews(view);
        this.setListener();
        return view;
    }


    @Override
    protected void initViews(View _view) {
        this.linearAccountLayout    = (LinearLayout) _view.findViewById(R.id.ll_account);

        this.rlMyWrokRecordLayout   = (RelativeLayout) _view.findViewById(R.id.rl_work_record);
        this.rlMyServiceLayout      = (RelativeLayout) _view.findViewById(R.id.rl_my_service);
        this.rlMyNeedLayout         = (RelativeLayout) _view.findViewById(R.id.rl_my_need);

        this.rlMyPhoneLayout        = (RelativeLayout) _view.findViewById(R.id.rl_my_phone);
        this.rlMyAddressLayout      = (RelativeLayout) _view.findViewById(R.id.rl_my_address);

        this.ivAvatar = (ImageView) _view.findViewById(R.id.civ_head);
        this.tvAccountName = (TextView) _view.findViewById(R.id.tv_account_name);
        this.tvInfoDetail = (TextView) _view.findViewById(R.id.tv_account_sign);

        this.tvPhone = (TextView) _view.findViewById(R.id.tv_my_phone);
        this.tvAddress = (TextView) _view.findViewById(R.id.tv_my_address);
    }

    @Override
    protected void setListener() {
        linearAccountLayout.setOnClickListener(this);

        rlMyWrokRecordLayout.setOnClickListener(this);
        rlMyServiceLayout.setOnClickListener(this);
        rlMyNeedLayout.setOnClickListener(this);

        rlMyPhoneLayout.setOnClickListener(this);
        rlMyAddressLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_account:
            break;
            case R.id.rl_work_record:
                break;
            case R.id.rl_my_service:
                break;
            case R.id.rl_my_need:
                break;
            default:
                break;
        }
    }
}
