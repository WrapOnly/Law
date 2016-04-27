package com.handle.law.fragment.subfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.handle.law.R;
import com.handle.law.adapter.friend.ChatSubFragmentAdapter;
import com.handle.law.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/27.
 */
public class ChatSubFragment extends BaseFragment implements View.OnClickListener {

    private ListView lvChatSub;
    private ChatSubFragmentAdapter chatSubFragmentAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View views = inflater.inflate(R.layout.chat_sub_fragment_activity, container, false);
        this.initViews(views);
        this.setListener();
        return views;
    }

    @Override
    protected void initViews(View _view) {
        this.lvChatSub = (ListView) _view.findViewById(R.id.lv_chat_sub_fragment);
        this.chatSubFragmentAdapter = new ChatSubFragmentAdapter(getActivity(), new ArrayList<String>(0));
        this.lvChatSub.setAdapter(this.chatSubFragmentAdapter);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public void onClick(View v) {

    }
}
