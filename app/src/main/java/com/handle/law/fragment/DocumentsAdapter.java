package com.handle.law.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.handle.law.R;

/**
 * Created by tiantan on 2016/4/28.
 */
public class DocumentsAdapter extends BaseAdapter {

    private Context mContext;
    private String[] dataStore;

    public DocumentsAdapter(Context mContext, String[] dataStore) {
        this.mContext = mContext;
        this.dataStore = dataStore;
    }

    @Override
    public int getCount() {
        return this.dataStore == null ? 0 : this.dataStore.length;
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
        String contentName = this.dataStore[position];
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.document_fragment_grid_view_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvName.setText(contentName);
        return convertView;
    }

    private static class ViewHolder {
        public final TextView tvName;
        public final View convertView;
        public ViewHolder(View _convertView){
            tvName = (TextView) _convertView.findViewById(R.id.tv_item_name);
            this.convertView = _convertView;
        }
    }
}
