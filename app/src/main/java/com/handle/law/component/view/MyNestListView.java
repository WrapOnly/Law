package com.handle.law.component.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

public class MyNestListView extends ListView{

	public MyNestListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MyNestListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyNestListView(Context context) {
		super(context);
	}
	/**
	 * 设置不滚动
	 */
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
