package com.handle.law.adapter.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.handle.law.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/27.
 */
public class ChatSubFragmentAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<String>  dataStore = new ArrayList<String>(0);
    private LayoutInflater layoutInflater;

    public ChatSubFragmentAdapter(Context mContext, ArrayList<String> dataStore) {
        this.mContext = mContext;
        this.dataStore = dataStore;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
//        return this.dataStore == null ? 0 : this.dataStore.size();
        return  5;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0L;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null){
            convertView = this.layoutInflater.inflate(R.layout.chat_sub_fragment_item_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
//        holder.ivAvatarView
        return convertView;
    }

    private static class ViewHolder{
        public final ImageView  ivAvatarView;
        public final TextView   tvNickName;
        public final TextView   tvMsgContent;
        public View convertView;

        public ViewHolder(View _convertView){
            this.convertView    = _convertView;
            this.ivAvatarView   = (ImageView) _convertView.findViewById(R.id.iv_chat_fragment_avatar_view);
            this.tvNickName     = (TextView) _convertView.findViewById(R.id.tv_chat_fragment_nick_name);
            this.tvMsgContent   = (TextView) _convertView.findViewById(R.id.tv_chat_fragment_msg_content);
        }
    }
}
