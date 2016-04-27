package com.handle.law.fragment.subfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handle.law.R;
import com.handle.law.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DynamicSubFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DynamicSubFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DynamicSubFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View views = inflater.inflate(R.layout.dynamic_sub_fragment_activity, container, false);
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
}
