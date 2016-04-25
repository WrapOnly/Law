package com.handle.law.component.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.handle.law.R;


public class MainTabView extends RelativeLayout {
	private Context		mContext;
	private TextView	mRedCountView;
	private TextView	mRedDotView;
	private ImageView	mIconView;
	private TextView	mTitleView;
	private GestureDetector detector = new GestureDetector(mContext, new TabGestureListener());
	private OnTabDoubleClickListener mListener;

	public MainTabView(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		this.mContext = context;
		LayoutInflater.from(context).inflate(R.layout.main_tab_view, this);
		mTitleView = (TextView) findViewById(R.id.tv_title);
		mIconView = (ImageView) findViewById(R.id.iv_icon);
		TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.TabView);
		int textColor = typedArray.getColor(R.styleable.TabView_textColor, getResources().getColor(R.color.gray_dark));
		Drawable iconDrawable = typedArray.getDrawable(R.styleable.TabView_iconDrawable);
		String text = typedArray.getString(R.styleable.TabView_text);
		String dotText = typedArray.getString(R.styleable.TabView_dotText);
		setTextColor(textColor);
		setText(text);
		setIconDrable(iconDrawable);
		typedArray.recycle();
	}
	
	public void setTextSize(float _textSize) {
		mTitleView.setTextSize(_textSize);
	}
	
	public void setTextColor(int _textColor) {
		mTitleView.setTextColor(_textColor);
	}
	
	public void setText(String _text) {
		mTitleView.setText(_text);
	}
	
	public void setText(int _text) {
		mTitleView.setText(mContext.getString(_text));
	}
	
	public void setIconDrable(Drawable _iconDrawable) {
		mIconView.setImageDrawable(_iconDrawable);
	}
	
	public void setIconDrable(int _iconDrawable) {
		mIconView.setImageResource(_iconDrawable);
	}
	
	public void setIconDrable(Bitmap _iconDrawable) {
		mIconView.setImageBitmap(_iconDrawable);
	}
	
	public void setCountText(int _dotText) {
		if (_dotText > 0 && _dotText <= 99) {
			mRedCountView.setText(String.valueOf(_dotText));
			mRedCountView.setVisibility(View.VISIBLE);
		}
		else if (_dotText > 99 ) {
			mRedCountView.setText("99+");
			mRedCountView.setVisibility(View.VISIBLE);
		}
		else {
			mRedCountView.setVisibility(View.GONE);
		}
	}
	
	public void setDotVisible(boolean visible) {
		if (visible) {
			mRedDotView.setVisibility(View.VISIBLE);
		}
		else {
			mRedDotView.setVisibility(View.GONE);
		}
	}
	
	public boolean getDotVisbility(){
		int visibility = mRedDotView.getVisibility();
		if(View.VISIBLE == visibility) {
			return true;
		} else {
			return false;
		}
	}
	
	/**设置双击事件*/
	public void setOnTabDoubleClickListener (OnTabDoubleClickListener _listener) {
		this.mListener = _listener;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		this.detector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
	
	
	public interface OnTabDoubleClickListener {
		void onDoubleClick();
	}
	
	public class TabGestureListener extends SimpleOnGestureListener {

		@Override
		public boolean onDoubleTap(MotionEvent e) {
			if (mListener != null) {
				mListener.onDoubleClick();
			}
			return super.onDoubleTap(e);
		}
		
	}
}
