package com.handle.law.adapter.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.handle.law.R;

import java.util.ArrayList;


/**
 * Created by tiantan on 16/5/4.
 */
public class DynamicZoneListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> dataStore = new ArrayList<>(0);


    public DynamicZoneListAdapter(ArrayList<String> dataStore, Context mContext) {
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
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.dynamic_zone_body_list_view_item_layout, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView dynamicZoneBodyAvatarView;
        public TextView tvPostAccountName;
        public TextView tvPostDateTime;
        public TextView tvDynamicBodyPostContent;
        public GridView gvDynamicBodyPictureGridViewLayout;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.dynamicZoneBodyAvatarView = (ImageView) rootView.findViewById(R.id.dynamic_zone_body_avatar_view);
            this.tvPostAccountName = (TextView) rootView.findViewById(R.id.tv_post_account_name);
            this.tvPostDateTime = (TextView) rootView.findViewById(R.id.tv_post_date_time);
            this.tvDynamicBodyPostContent = (TextView) rootView.findViewById(R.id.tv_dynamic_body_post_content);
            this.gvDynamicBodyPictureGridViewLayout = (GridView) rootView.findViewById(R.id.gv_dynamic_body_picture_grid_view_layout);
        }

    }
}
