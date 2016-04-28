package com.handle.law.fragment.subfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.handle.law.R;
import com.handle.law.adapter.friend.ContactSubFragmentBuddyGroupAdapter;
import com.handle.law.base.BaseFragment;

/**
 * Created by Administrator on 2016/4/28.
 */
public class ContactSubFragment extends BaseFragment implements
        View.OnClickListener, ExpandableListView.OnGroupCollapseListener,
        ExpandableListView.OnGroupExpandListener, ExpandableListView.OnChildClickListener{

    private LinearLayout        llNewFriendLayout;
    private ExpandableListView  expandableListView;
    private ContactSubFragmentBuddyGroupAdapter buddyGroupAdapter;

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
        this.llNewFriendLayout  = (LinearLayout) _view.findViewById(R.id.ll_new_friend_layout);
        this.expandableListView = (ExpandableListView) _view.findViewById(R.id.expand_list_view);
        this.buddyGroupAdapter = new ContactSubFragmentBuddyGroupAdapter(getActivity());
        this.expandableListView.setAdapter(this.buddyGroupAdapter);
        this.expandableListView.setGroupIndicator(null);
    }

    @Override
    protected void setListener() {
        this.llNewFriendLayout.setOnClickListener(this);
        this.expandableListView.setOnGroupCollapseListener(this);
        this.expandableListView.setOnGroupExpandListener(this);
        this.expandableListView.setOnChildClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_new_friend_layout:
                break;
        }
    }

    /**子项被单击时*/
    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return false;
    }

    /**分组关闭*/
    @Override
    public void onGroupCollapse(int groupPosition) {

    }

    /**分组展开*/
    @Override
    public void onGroupExpand(int groupPosition) {

    }
}
