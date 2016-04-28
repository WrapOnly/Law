package com.handle.law.adapter.friend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.handle.law.R;

/**
 * Created by Administrator on 2016/4/29.
 */
public class ContactSubFragmentBuddyGroupAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private String[] groupName = {"friend", "leader", "fans"};
    private String[][] childName = new String[][]{{"分组一", "分组二", "分组三"}, {"1", "2", "3"}, {"分组一", "分组二", "分组三"}};

    public ContactSubFragmentBuddyGroupAdapter(Context _mContext){
        this.mContext = _mContext;
    }
    @Override
    public int getGroupCount() {
        return this.groupName.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.childName.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.buddy_list_view_group_item, null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        }
        else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        groupViewHolder.tvGroupNameView.setText(this.groupName[groupPosition]);
        /**
         *         //更换展开分组图片  
                 if(!isExpanded){ 
                     image.setImageResource(R.drawable.group_fold_arrow); 
                 }
         */
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(this.mContext).inflate(R.layout.buddy_list_view_child_item, null);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        }
        else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.tvChildNickNameView.setText(childName[groupPosition][childPosition]);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class GroupViewHolder{
        public final ImageView  ivGroupAvatarView;
        public final ImageView  ivGroupMarkView;
        public final TextView   tvGroupNameView;
        public View groupConvertView;

        public GroupViewHolder(View _groupConvertView){
            this.groupConvertView   = _groupConvertView;
            this.ivGroupAvatarView  = (ImageView) _groupConvertView.findViewById(R.id.buddy_list_view_group_avatar);
            this.ivGroupMarkView    = (ImageView) _groupConvertView.findViewById(R.id.buddy_list_view_group_mark);
            this.tvGroupNameView    = (TextView) _groupConvertView.findViewById(R.id.buddy_list_view_group_name);
        }
    }

    private static class ChildViewHolder{
        public final ImageView  ivChildAvatarView;
        public final TextView   tvChildNickNameView;
        public final TextView   tvChildDynamicInfoView;
        public View childConvertView;
        public ChildViewHolder(View _childConvertView){
            this.childConvertView           = _childConvertView;
            this.ivChildAvatarView          = (ImageView) _childConvertView.findViewById(R.id.buddy_list_view_child_avatar_view);
            this.tvChildNickNameView        = (TextView) _childConvertView.findViewById(R.id.buddy_list_view_child_nick_name);
            this.tvChildDynamicInfoView     = (TextView) _childConvertView.findViewById(R.id.buddy_list_view_group_name);
        }
    }
}
