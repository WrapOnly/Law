package com.handle.law.adapter.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.handle.law.R;

import java.util.ArrayList;

/**
 * Created by tiantan on 2016/5/4.
 */
public class DynamicRelatedToMeListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> dataStore = new ArrayList<>(0);

    public DynamicRelatedToMeListAdapter(ArrayList<String> dataStore, Context mContext) {
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
        if (convertView == null) {
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.dynamic_zone_related_to_me_list_item_layout, null);
//            viewHolder = new ViewHolder(convertView);
//            convertView.setTag(viewHolder);
        }
        else {
//            viewHolder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }
}
