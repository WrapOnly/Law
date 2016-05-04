package com.handle.law.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class MyNestGridView extends GridView {

    public MyNestGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyNestGridView(Context context) {
		super(context);
	}

    /** 设置不滚动  */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
