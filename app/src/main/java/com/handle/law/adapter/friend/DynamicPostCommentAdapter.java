package com.handle.law.adapter.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.handle.law.R;

import java.util.ArrayList;

/**
 * Created by tiantan on 16/5/4.
 */
public class DynamicPostCommentAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> dataStore = new ArrayList<>(0);


    public DynamicPostCommentAdapter(ArrayList<String> dataStore, Context mContext) {
        this.dataStore = dataStore;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.dynamic_zone_bottom_comment_item_layout, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public TextView tvDynamicBottomCommentRecord;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.tvDynamicBottomCommentRecord = (TextView) rootView.findViewById(R.id.tv_dynamic_bottom_comment_record);
        }

    }
}
