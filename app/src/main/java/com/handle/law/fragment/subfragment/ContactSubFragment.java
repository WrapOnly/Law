package com.handle.law.fragment.subfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handle.law.R;
import com.handle.law.base.BaseFragment;

/**
 * Created by Administrator on 2016/4/28.
 */
public class ContactSubFragment extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View views = inflater.inflate(R.layout.contact_sub_fragment_activity, container, false);
        this.initViews(views);
        this.setListener();
        return views;
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
