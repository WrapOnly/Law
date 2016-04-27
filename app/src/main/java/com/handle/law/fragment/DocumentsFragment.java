package com.handle.law.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handle.law.R;
import com.handle.law.base.BaseFragment;

/**
 * Created by Administrator on 2016/4/25.
 */
public class DocumentsFragment extends BaseFragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.my_document_fragment_layout, container, false);
        this.initViews(view);
        this.setListener();
        return view;
    }

    @Override
    protected void initViews(View _view) {

    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
