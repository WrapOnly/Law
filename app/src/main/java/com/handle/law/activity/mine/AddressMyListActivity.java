package com.handle.law.activity.mine;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.handle.law.R;
import com.handle.law.base.BaseActivity;
import com.handle.law.bean.AddressBean;
import com.handle.law.component.view.SwipeListView;
import com.handle.law.constant.MainConstant;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/1.
 */
public class AddressMyListActivity extends BaseActivity implements View.OnClickListener{

    private SwipeListView           mAddressView;
    private ImageView               mBackView;
    private ArrayList<AddressBean> addressList;
    private AddressAdapter 			addressAdapter;
    private View					itemView;
    private int 					itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_address_my_list_activity);
    }

    @Override
    protected void initViews() {
        mAddressView 	= (SwipeListView) findViewById(R.id.slv_address);
        mBackView 		= (ImageView) findViewById(R.id.iv_back);
    }

    @Override
    protected void setListener() {
        mBackView.setOnClickListener(this);
        mAddressView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long arg3) {
                long addressId = addressList.get(position).getAddressId();
                Intent intent = new Intent(AddressMyListActivity.this, AddAddressActivity.class);
                intent.putExtra(MainConstant.ADDRESS_ID, addressId);
                intent.putExtra(MainConstant.ADDRESS_SELECT_TYPE, false);//可以不发送，因为默认是false
                startActivityForResult(intent, MainConstant.ADDRESS_CHANGE);
                overridePendingTransition(R.anim.slide_left_in,R.anim.slide_left_out);
            }
        });

        mAddressView.setOnItemDeleteListener(new SwipeListView.OnItemDeleteListener() {
            @Override
            public void onDeleteListViewItem(int position) {
                if (addressAdapter != null) {
                    addressAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                this.onBackPressed();
                break;

        }
    }

    public void setAddressAdapter(){
        if (addressAdapter == null) {
            addressAdapter = new AddressAdapter(mAddressView.getRightViewWidth());
            mAddressView.setAdapter(addressAdapter);
        }
        else {
            addressAdapter.notifyDataSetChanged();
        }
    }

    public class AddressAdapter extends BaseAdapter {
        private int mRightWidth;
        public AddressAdapter(int mRightWidth) {
            this.mRightWidth = mRightWidth;
        }

        @Override
        public int getCount() {
            return addressList == null ? 0 : addressList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(final int position, View view, ViewGroup group) {
            ViewHold viewHold;
            if (view == null) {
                view = LayoutInflater.from(AddressMyListActivity.this).inflate(R.layout.address_my_list_item, null);
                viewHold = new ViewHold();
                viewHold.tvName = (TextView) view.findViewById(R.id.tv_name);
                viewHold.tvPhone = (TextView) view.findViewById(R.id.tv_phone);
                viewHold.tvAddress = (TextView) view.findViewById(R.id.tv_address);
//                viewHold.tvDefault = (TextView) view.findViewById(R.id.tv_default);
                viewHold.itemRight = (RelativeLayout) view.findViewById(R.id.item_right);
                viewHold.itemLeft = (LinearLayout) view.findViewById(R.id.item_left);
                LinearLayout.LayoutParams lp_left = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                viewHold.itemLeft.setLayoutParams(lp_left);
                LinearLayout.LayoutParams lp_right = new LinearLayout.LayoutParams(mRightWidth,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                viewHold.itemRight.setLayoutParams(lp_right);
                view.setTag(viewHold);
            } else {
                viewHold = (ViewHold) view.getTag();
            }
            final AddressBean addressBean = addressList.get(position);
            viewHold.tvName.setText(addressBean.getName());
            String mPhone = addressBean.getPhone();
            if (mPhone.length() >= 11) {
                mPhone = mPhone.substring(0, 3)+"****"+mPhone.substring(mPhone.length()-4, mPhone.length());
            }
            viewHold.tvPhone.setText(mPhone);
            viewHold.tvAddress.setText(addressBean.toString());
//            if (addressBean.getbDefault() == CommonGlobal.ACCOUNT_DEFAULT_ADDRESS) {
//                viewHold.tvDefault.setVisibility(View.VISIBLE);
//            } else {
//                viewHold.tvDefault.setVisibility(View.INVISIBLE);
//            }
            viewHold.itemRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    WebuyApp.getInstance(AddressBookActivity.this).getRoot().getC2SCtrl().deleteAddress(addressModel.getAddressId());
                    itemPosition = position;
                    itemView = mAddressView.getChildAt(position - mAddressView.getFirstVisiblePosition());
                }
            });
            return view;
        }

        class ViewHold {
            TextView tvName;
            TextView tvPhone;
            TextView tvDefault;
            TextView tvAddress;
            RelativeLayout itemRight;
            LinearLayout itemLeft;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }
}
