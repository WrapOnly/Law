package com.handle.law.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.handle.law.R;
import com.handle.law.base.BaseFragment;
import com.handle.law.constant.MainConstant;
import com.handle.law.fragment.subfragment.ChatSubFragment;
import com.handle.law.fragment.subfragment.ContactSubFragment;
import com.handle.law.fragment.subfragment.DynamicSubFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/25.
 */
public class FriendFragment extends BaseFragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    private ImageView           qrCodeImageView;
    private ImageView           qrCodeScanImageView;
    private ImageView           searchFriendImageView;
    private ImageView           addFriendImageView;

    private List<Fragment>      contactsFragments 	= new ArrayList<Fragment>(0);
    private int                 mContentId;
    private int					mCurrentFragmentIdx = 0;
    private RadioGroup          headerRadioGroup;
    private RadioButton         chatRadioBtn;
    private RadioButton 		dynamicRadioBtn;
    private RadioButton 		contactRadioBtn;
    private TextView            chatLine;
    private TextView            dynamicLine;
    private TextView            contacsLine;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mContentId 	= R.id.friend_layout_fragment_container;
        View view   = inflater.inflate(R.layout.friend_fragment_layout, container, false);
        this.initViews(view);
        this.setListener();
        return view;
    }

    @Override
    protected void initViews(View _view) {
        qrCodeImageView         = (ImageView) _view.findViewById(R.id.iv_friend_fragment_qrcode);
        qrCodeScanImageView     = (ImageView) _view.findViewById(R.id.iv_friend_fragment_qrcode_scan);
        searchFriendImageView   = (ImageView) _view.findViewById(R.id.iv_friend_fragment_search);
        addFriendImageView      = (ImageView) _view.findViewById(R.id.iv_friend_fragment_add);

        headerRadioGroup        = (RadioGroup) _view.findViewById(R.id.radiogroud__friend_group);
        chatRadioBtn 		    = (RadioButton) _view.findViewById(R.id.radio_btn_chat);
        dynamicRadioBtn 	    = (RadioButton) _view.findViewById(R.id.radio_btn_dynamic);
        contactRadioBtn 		= (RadioButton) _view.findViewById(R.id.radio_btn_contact);
        chatLine                = (TextView) _view.findViewById(R.id.friends_chat_line);
        dynamicLine             = (TextView) _view.findViewById(R.id.friend_dynamic_line);
        contacsLine             = (TextView) _view.findViewById(R.id.friend_contacts_line);
        if(contactsFragments.isEmpty()) {
            contactsFragments.add(new ChatSubFragment());
            contactsFragments.add(new DynamicSubFragment());
            contactsFragments.add(new ContactSubFragment());
        }
        try {
            if(!contactsFragments.get(mCurrentFragmentIdx).isAdded()) {
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.add(mContentId, contactsFragments.get(mCurrentFragmentIdx));
                transaction.commit();
                getChildFragmentManager().executePendingTransactions();
            }
        }
        catch(IllegalStateException _e) {
            _e.printStackTrace();
        }
        chatLine.setBackgroundColor(getResources().getColor(R.color.orange));
        chatRadioBtn.setTextColor(getResources().getColor(R.color.orange));
        chatRadioBtn.setGravity(Gravity.CENTER);
    }

    @Override
    protected void setListener() {
        headerRadioGroup.setOnCheckedChangeListener(this);
        qrCodeImageView.setOnClickListener(this);
        qrCodeScanImageView.setOnClickListener(this);
        searchFriendImageView.setOnClickListener(this);
        addFriendImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //二维码
            case R.id.iv_friend_fragment_qrcode:
                break;
            //扫描二维码
            case R.id.iv_friend_fragment_qrcode_scan:
                break;
            //搜索
            case R.id.iv_friend_fragment_search:
                break;
            //添加
            case R.id.iv_friend_fragment_add:
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_btn_chat:
                mCurrentFragmentIdx = MainConstant.TAG_FRIEND_CHAT;
                break;
            case R.id.radio_btn_dynamic:
                mCurrentFragmentIdx = MainConstant.TAG_FRIEND_DYNAMIC;
                break;
            case R.id.radio_btn_contact:
                mCurrentFragmentIdx = MainConstant.TAG_FRIEND_CONTACT;
                break;
        }
        this.showTab(mCurrentFragmentIdx);
        this.setBackgroundColor(mCurrentFragmentIdx);
    }

    private void showTab(int index) {
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        Fragment mFragment = this.contactsFragments.get(index);
        if (mFragment.isAdded()) {
            mFragment.onResume();
        }
        else {
            try {
                ft.add(mContentId, mFragment);
            }
            catch(IllegalStateException _e) {
                _e.printStackTrace();
            }
        }
        ft.commit();
        for (int i = 0; i < contactsFragments.size(); i++) {
            FragmentTransaction mFragmentTransaction = getChildFragmentManager().beginTransaction();
            mFragment = this.contactsFragments.get(i);
            if (index == i) {
                mFragmentTransaction.show(mFragment);
            }
            else {
                mFragmentTransaction.hide(mFragment);
            }
            mFragmentTransaction.commit();
        }
    }

    protected void setBackgroundColor(int _tag) {
        if (_tag == MainConstant.TAG_FRIEND_CHAT) {
            chatRadioBtn.setTextColor(getResources().getColor(R.color.orange));
            dynamicRadioBtn.setTextColor(getResources().getColor(R.color.black));
            contactRadioBtn.setTextColor(getResources().getColor(R.color.black));
            chatLine.setBackgroundColor(getResources().getColor(R.color.orange));
            dynamicLine.setBackgroundColor(getResources().getColor(R.color.white));
            contacsLine.setBackgroundColor(getResources().getColor(R.color.white));
        }
        else if (_tag == MainConstant.TAG_FRIEND_DYNAMIC) {
            dynamicRadioBtn.setTextColor(getResources().getColor(R.color.orange));
            chatRadioBtn.setTextColor(getResources().getColor(R.color.black));
            contacsLine.setTextColor(getResources().getColor(R.color.black));
            dynamicLine.setBackgroundColor(getResources().getColor(R.color.orange));
            chatLine.setBackgroundColor(getResources().getColor(R.color.white));
            contacsLine.setBackgroundColor(getResources().getColor(R.color.white));
        }
        else if (_tag == MainConstant.TAG_FRIEND_CONTACT) {
            contactRadioBtn.setTextColor(getResources().getColor(R.color.orange));
            chatRadioBtn.setTextColor(getResources().getColor(R.color.black));
            dynamicRadioBtn.setTextColor(getResources().getColor(R.color.black));
            contacsLine.setBackgroundColor(getResources().getColor(R.color.orange));
            chatLine.setBackgroundColor(getResources().getColor(R.color.white));
            dynamicLine.setBackgroundColor(getResources().getColor(R.color.white));
        }
    }


}
