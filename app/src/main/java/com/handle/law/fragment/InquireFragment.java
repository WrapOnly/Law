package com.handle.law.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.handle.law.R;
import com.handle.law.base.BaseFragment;

/**
 * Created by Administrator on 2016/4/25.
 */
public class InquireFragment extends BaseFragment implements View.OnClickListener{

    /**-------明细账查询------*/
    private RelativeLayout rlOrderDetailQuery;
    private LinearLayout rlOrderDetailQueryLayout;
    /**更多明细账查询操作*/
    private ImageView   ivOrderDetailMore;
    /**现金账户*/
    private Button btnAccountCash;
    /**存货明细*/
    private Button btnSaveDetail;
    /**会计科目*/
    private Button btnProject;
    /**辅助核算*/
    private Button btnHelpCalculate;

    /**----报表查询------*/
    private RelativeLayout rlTableQuery;
    private LinearLayout rlTableQueryLayout;
    /**更多明细账查询操作*/
    private ImageView   ivTableDetailMore;
    /**现金账户统计表*/
    private Button btnAccountCashTable;
    /**存货统计表*/
    private Button btnSaveDetailTable;
    /**会计科目余额表*/
    private Button btnProjectTable;
    /**辅助核算统计表*/
    private Button btnHelpCalculateTable;

    /**----合同管理------*/
    private RelativeLayout rlOrderManage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.query_order_list_activity, container, false);
        this.initViews(view);
        this.setListener();
        return view;
    }

    @Override
    protected void initViews(View _view) {

        rlOrderDetailQuery  = (RelativeLayout) _view.findViewById(R.id.rl_order_detail_query);
        rlOrderDetailQueryLayout  = (LinearLayout) _view.findViewById(R.id.query_detail_layout);
        ivOrderDetailMore   = (ImageView) _view.findViewById(R.id.iv_order_more);
        btnAccountCash      = (Button) _view.findViewById(R.id.btn_account_cash);
        btnSaveDetail       = (Button) _view.findViewById(R.id.btn_account_detail);
        btnProject          = (Button) _view.findViewById(R.id.btn_project);
        btnHelpCalculate    = (Button) _view.findViewById(R.id.btn_help_cul);

        rlTableQuery        = (RelativeLayout) _view.findViewById(R.id.rl_table_query);
        rlTableQueryLayout  = (LinearLayout) _view.findViewById(R.id.order_detail01_layout);
        ivTableDetailMore   = (ImageView) _view.findViewById(R.id.iv_table_mores);
        btnAccountCash      = (Button) _view.findViewById(R.id.btn_account_cash_table);
        btnSaveDetail       = (Button) _view.findViewById(R.id.btn_save_good_table);
        btnProject          = (Button) _view.findViewById(R.id.btn_project_balance_table);
        btnHelpCalculate    = (Button) _view.findViewById(R.id.btn_help_cul_table);
        rlOrderManage       = (RelativeLayout) _view.findViewById(R.id.rl_order_manage);
    }

    @Override
    protected void setListener() {
        rlOrderDetailQuery.setOnClickListener(this);
        ivOrderDetailMore.setOnClickListener(this);
        btnAccountCash.setOnClickListener(this);
        btnSaveDetail.setOnClickListener(this);
        btnProject.setOnClickListener(this);
        btnHelpCalculate.setOnClickListener(this);

        rlTableQuery.setOnClickListener(this);
        ivTableDetailMore.setOnClickListener(this);
        btnAccountCash.setOnClickListener(this);
        btnSaveDetail.setOnClickListener(this);
        btnProject.setOnClickListener(this);
        btnHelpCalculate.setOnClickListener(this);

        rlOrderManage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_order_detail_query:
                break;
            case R.id.iv_order_more:
                break;
            case R.id.btn_account_cash:
                break;
            case R.id.btn_account_detail:
                break;
            case R.id.btn_project:
                break;
            case R.id.btn_help_cul:
                break;
            case R.id.rl_table_query:
                break;
            case R.id.iv_table_mores:
                break;
            case R.id.btn_account_cash_table:
                break;
            case R.id.btn_save_good_table:
                break;
            case R.id.btn_project_balance_table:
                break;
            case R.id.rl_order_manage:
                break;
        }
    }
}
