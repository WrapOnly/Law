package com.handle.law;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.handle.law.base.BaseFragmentActivity;
import com.handle.law.component.view.MainTabView;
import com.handle.law.constant.MainConstant;
import com.handle.law.fragment.DocumentsFragment;
import com.handle.law.fragment.FriendFragment;
import com.handle.law.fragment.InquireFragment;
import com.handle.law.fragment.MineFragment;
import com.handle.law.fragment.MyOfficeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseFragmentActivity implements View.OnClickListener {

    private List<Fragment> allFragments = new ArrayList<Fragment>(0);
    private MainTabView[] mTabView 	= null;
    private int currentFramentIndex = 0;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.loadFragmentData();
        this.initViews();
        this.setListener();
    }

    @Override
    protected void initViews() {
        mTabView = new MainTabView[allFragments.size()];
        mTabView[MainConstant.BOTTOM_TAB_FRIEND] 	= (MainTabView) findViewById(R.id.tb_friend);
        mTabView[MainConstant.BOTTOM_TAB_OFFICE] 	= (MainTabView) findViewById(R.id.tb_my_office);
        mTabView[MainConstant.BOTTOM_TAB_DOCUMENT] 	= (MainTabView) findViewById(R.id.tb_document);
        mTabView[MainConstant.BOTTOM_TAB_INQURIE] 	= (MainTabView) findViewById(R.id.tb_inquire);
        mTabView[MainConstant.BOTTOM_TAB_MINE] 		= (MainTabView) findViewById(R.id.tb_mine);
        /**暂时先注释，后面做登录之后进行切换使用*/
//        if (LawApplication.getInstance().isFirstLogin){
//            mTabView[MainConstant.BOTTOM_TAB_OFFICE].setVisibility(View.VISIBLE);
//            mTabView[MainConstant.BOTTOM_TAB_DOCUMENT].setVisibility(View.GONE);
//            mTabView[MainConstant.BOTTOM_TAB_INQURIE].setVisibility(View.GONE);
//        }
//        else {
//            mTabView[MainConstant.BOTTOM_TAB_OFFICE].setVisibility(View.GONE);
//            mTabView[MainConstant.BOTTOM_TAB_DOCUMENT].setVisibility(View.VISIBLE);
//            mTabView[MainConstant.BOTTOM_TAB_INQURIE].setVisibility(View.VISIBLE);
//        }
        mTabView[MainConstant.BOTTOM_TAB_FRIEND].setIconDrable(R.mipmap.main_chatf);
        mTabView[MainConstant.BOTTOM_TAB_FRIEND].setTextColor(getResources().getColor(R.color.black));

        if (!allFragments.get(MainConstant.BOTTOM_TAB_FRIEND).isAdded()) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.main_tab_content, allFragments.get(MainConstant.BOTTOM_TAB_FRIEND));
            ft.commit();
        }
    }

    @Override
    protected void setListener() {
        mTabView[MainConstant.BOTTOM_TAB_FRIEND].setOnClickListener(this);
        mTabView[MainConstant.BOTTOM_TAB_OFFICE].setOnClickListener(this);
        mTabView[MainConstant.BOTTOM_TAB_DOCUMENT].setOnClickListener(this);
        mTabView[MainConstant.BOTTOM_TAB_INQURIE].setOnClickListener(this);
        mTabView[MainConstant.BOTTOM_TAB_MINE].setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Fragment mFragment = this.allFragments.get(this.currentFramentIndex);
        mFragment.onPause();
        reSetView();
        switch (view.getId()) {
            case R.id.tb_friend:
                mTabView[MainConstant.BOTTOM_TAB_FRIEND].setIconDrable(R.mipmap.main_chatf);
                this.currentFramentIndex = MainConstant.BOTTOM_TAB_FRIEND;
                break;
            case R.id.tb_my_office:
                mTabView[MainConstant.BOTTOM_TAB_OFFICE].setIconDrable(R.mipmap.main_chatf);
                this.currentFramentIndex = MainConstant.BOTTOM_TAB_OFFICE;
                break;
            case R.id.tb_document:
                mTabView[MainConstant.BOTTOM_TAB_DOCUMENT].setIconDrable(R.mipmap.main_chatf);
                this.currentFramentIndex = MainConstant.BOTTOM_TAB_DOCUMENT;
                break;
            case R.id.tb_inquire:
                mTabView[MainConstant.BOTTOM_TAB_INQURIE].setIconDrable(R.mipmap.main_chatf);
                this.currentFramentIndex = MainConstant.BOTTOM_TAB_INQURIE;
                break;
            case R.id.tb_mine:
                mTabView[MainConstant.BOTTOM_TAB_MINE].setIconDrable(R.mipmap.main_chatf);
                this.currentFramentIndex = MainConstant.BOTTOM_TAB_MINE;
                break;
        }
        mTabView[this.currentFramentIndex].setTextColor(getResources().getColor(
                R.color.black));
        this.showTab(this.currentFramentIndex);
    }

    private void showTab(int index) {
        Fragment mFragment = this.allFragments.get(index);
        if (mFragment.isAdded()) {
            mFragment.onResume();
        } else {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.main_tab_content, mFragment);
            fragmentTransaction.commit();
            getSupportFragmentManager().executePendingTransactions();
        }

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < mTabView.length; i++) {
            Fragment fragment = this.allFragments.get(i);
            if (index == i) {
                fragmentTransaction.show(fragment);
            } else {
                fragmentTransaction.hide(fragment);
            }
        }
        fragmentTransaction.commit();
    }
    public void loadFragmentData(){
        if (this.allFragments.isEmpty()){
            this.allFragments.add(new FriendFragment());
            this.allFragments.add(new MyOfficeFragment());
            this.allFragments.add(new DocumentsFragment());
            this.allFragments.add(new InquireFragment());
            this.allFragments.add(new MineFragment());
        }
    }
    private void reSetView() {
        mTabView[MainConstant.BOTTOM_TAB_FRIEND].setIconDrable(R.mipmap.main_chatb);
        mTabView[MainConstant.BOTTOM_TAB_OFFICE].setIconDrable(R.mipmap.main_chatb);
        mTabView[MainConstant.BOTTOM_TAB_DOCUMENT].setIconDrable(R.mipmap.main_chatb);
        mTabView[MainConstant.BOTTOM_TAB_INQURIE].setIconDrable(R.mipmap.main_chatb);
        mTabView[MainConstant.BOTTOM_TAB_MINE].setIconDrable(R.mipmap.main_chatb);
        for (MainTabView aMTabView : mTabView) {
            aMTabView.setTextColor(getResources().getColor(R.color.gray_dark));
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    assert v != null;
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        return getWindow().superDispatchTouchEvent(ev) || onTouchEvent(ev);
    }

    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = { 0, 0 };
            // 获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom);
        }
        return false;
    }

    public MainTabView[] getMainTabView() {
        return this.mTabView;
    }

    public int getCurrentFragmentIdx() {
        return this.currentFramentIndex;
    }
}
