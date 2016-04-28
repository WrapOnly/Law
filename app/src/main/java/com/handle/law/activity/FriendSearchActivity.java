package com.handle.law.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.handle.law.R;
import com.handle.law.base.BaseActivity;
import com.handle.law.component.edittext.EditTextWithDel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiantan on 2016/4/28.
 */
public class FriendSearchActivity  extends BaseActivity implements View.OnClickListener, TextWatcher {

    private List<String> accountDataStore 	= new ArrayList<String>(0);
    private ListView mListView;
//    private ContactsSearchAdapter mAdapter;
    private EditTextWithDel editTextWithDel;
    private TextView        searchAction;
    private String 			mSearchString;
    private MyHandler		myHandler;
    private ImageView       ivBack;

    //防止内存泄漏
    private static class MyHandler extends Handler {
        WeakReference<FriendSearchActivity> mActivity;
        public MyHandler(FriendSearchActivity activity) {
            mActivity = new WeakReference<FriendSearchActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            FriendSearchActivity theActivity = mActivity.get();
            theActivity.handleSearchResult();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_quick_search_activity);
        this.initViews();
        this.setListener();
        this.showKeyBoard();
    }

    @Override
    protected void initViews() {
        ivBack 			    = (ImageView) findViewById(R.id.iv_back);
        editTextWithDel 	= (EditTextWithDel) findViewById(R.id.include_search_et_content);
        searchAction        = (TextView) findViewById(R.id.include_search_tv_action);
        mListView 			= (ListView) findViewById(R.id.contacts_quick_search_lv);

//        editTextWithDel.setHint(getString(R.string.contact_local_search_hint));
        myHandler           = new MyHandler(this);
    }

    @Override
    protected void setListener() {
        ivBack.setOnClickListener(this);
        editTextWithDel.addTextChangedListener(this);
        editTextWithDel.setCursorVisible(true);
        searchAction.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.onBackPressed();
    }

    private void showKeyBoard() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                editTextWithDel.requestFocus();
                ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                        .showSoftInput(editTextWithDel, 0);
            }
        }, 200);//delay 1000ms stop record

    }

    private void hideKeyBoard() {
        if (FriendSearchActivity.this.getCurrentFocus() != null) {
            ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(FriendSearchActivity.this
                                    .getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
    private void handleSearchResult() {
//        if (!Validator.isEmpty(mSearchString) && accountDataStore.size() != 0) {
//            List<AccountModel> searchDataStore = ContactsSearchUtil.search(mSearchString, accountDataStore);
//            if (searchDataStore.size() != 0) {
//                noResultLayout.setVisibility(View.GONE);
//                mNoMatchResultView.setVisibility(View.GONE);
//                //快速搜索的可能是friend或者leader
//                mAdapter = new ContactsFansOrSearchAdapter(ContactLocalSearchActivity.this, searchDataStore, ContactsGlobal.CONTACT_TYPE_QUICK_SEARCH_FRIEND_OR_LEADER);
//                mListView.setAdapter(mAdapter);
//            }
//            else {
//                if (mAdapter != null) {
//                    mAdapter.clear();
//                }
//                noResultLayout.setVisibility(View.VISIBLE);
//                mNoMatchResultView.setVisibility(View.VISIBLE);
//            }
//
//        }
//        else {
//            if (mAdapter != null) {
//                mAdapter.clear();
//            }
//            noResultLayout.setVisibility(View.VISIBLE);
//            mNoMatchResultView.setVisibility(View.VISIBLE);
//        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) { }

    @Override
    public void afterTextChanged(final Editable s) {
        mSearchString = s.toString().trim();
        if (TextUtils.isEmpty(mSearchString)) {
//            if (mAdapter != null) {
//                mAdapter.clear();
//            }
            searchAction.setText("取消");
            this.showKeyBoard();
        }
        else{
            myHandler.sendEmptyMessage(0);
        }
    }

    @Override
    protected void onDestroy() {
        this.hideKeyBoard();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }

}
