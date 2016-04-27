package com.handle.law.component.commondailog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.handle.law.R;
import com.handle.law.constant.MainConstant;

public class CommonDialog extends Dialog implements TextWatcher{
	private TextView mTitleView;
	private TextView mTitleDivideView;
	private TextView mBtnDivideView;
	private TextView mMessageView;
	private EditText mContentView;
	private ImageView mEditImageView;
	private TextView mImageView;
	private Button mPosiviteView;
	private Button mNegativeView;
	private LinearLayout mEditLayout;
	private LinearLayout mSingleLayout;
	private FrameLayout mFameRemarkLayout;
	private EditText  mRemarkContentView;
	private TextView mCountView;
	private Context context;
	private boolean positiveShown;
	private boolean negativeShown;
	private ImageView ivClose;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (positiveShown && !negativeShown) {
			mPosiviteView.setBackgroundResource(R.drawable.dialog_btn_only_one_style_selector);
		}
		else if (negativeShown && !positiveShown) {
			mNegativeView.setBackgroundResource(R.drawable.dialog_btn_only_one_style_selector);
		}
		else if (negativeShown && positiveShown) {
			mBtnDivideView.setVisibility(View.VISIBLE);
		}
	}

	public CommonDialog(Context context, int theme) {
		super(context, theme);
	}

	public CommonDialog(Context context, boolean cancelable,   OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}

	@SuppressLint("InflateParams")
	public CommonDialog(Context context){
		super(context, R.style.customdialog);
		this.context = context;
		int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
		View view = LayoutInflater.from(context).inflate(R.layout.common_dialog, null);
		setContentView(view);
		LayoutParams lp = (LayoutParams) view.getLayoutParams();
		lp.width = screenWidth - 80;
		lp.height = LayoutParams.WRAP_CONTENT;
		view.setLayoutParams(lp);
		ivClose				= (ImageView) findViewById(R.id.iv_close);
		mPosiviteView		= (Button) findViewById(R.id.bt_positive);
		mNegativeView 		= (Button) findViewById(R.id.bt_negative);
		mTitleView 			= (TextView) findViewById(R.id.tv_title);
		mTitleDivideView 	= (TextView) findViewById(R.id.tv_title_divide);
		mBtnDivideView 		= (TextView) findViewById(R.id.tv_btn_divide);
		mMessageView 		= (TextView) findViewById(R.id.tv_message);
		mNegativeView 		= (Button) findViewById(R.id.bt_negative);
		mContentView 		= (EditText) findViewById(R.id.et_content);
		mEditImageView 		= (ImageView) findViewById(R.id.iv_edit_image);
        mImageView 		    = (TextView) findViewById(R.id.iv_image);
		mEditLayout 		= (LinearLayout) findViewById(R.id.ll_edit);
		mSingleLayout 		= (LinearLayout) findViewById(R.id.ll_single_choise);
		mFameRemarkLayout 	= (FrameLayout) findViewById(R.id.fl_remark_layout);
		mRemarkContentView 	= (EditText) findViewById(R.id.et_msg);
		mCountView 			= (TextView) findViewById(R.id.tv_left_word_count);
	}

	public CommonDialog setClose(final OnClickCallback onClickCallback) {
		ivClose.setVisibility(View.VISIBLE);
		ivClose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
				if (onClickCallback != null) {
					onClickCallback.onClick();
				}
			}
		});
		return this;
	}
	public CommonDialog setCancel(boolean flag) {
		setCancelable(flag);
		return this;
	}

	public CommonDialog setTitle(String title) {
		mTitleView.setVisibility(View.VISIBLE);
		mTitleDivideView.setVisibility(View.VISIBLE);
		mTitleView.setText(title);
		return this;
	}

	public CommonDialog setMessage(String msg) {
		mMessageView.setVisibility(View.VISIBLE);
		mMessageView.setText(msg);
		return this;
	}
	
	/**
	 * 给可计数编辑框添加事件监听， 并输入默认内容
	 * @param msg
	 * @return
	 */
	public CommonDialog setRemarkMessage(String msg) {
		mRemarkContentView.addTextChangedListener(this);
		mRemarkContentView.setText(msg);
		mRemarkContentView.setSelection(msg.length());
		mTitleDivideView.setVisibility(View.GONE);
		mCountView.setText(String.format("%1$s/%2$s", msg.length(), MainConstant.REMARK_CHARACTER_MAX_LEN));
		return this;
	}

	public CommonDialog setPositiveButton(String text, final OnClickCallback onClickCallback) {
		mPosiviteView.setVisibility(View.VISIBLE);
		mPosiviteView.setText(text);
		mPosiviteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (onClickCallback != null) {
                    onClickCallback.onClick();
                }
            }
        });
		positiveShown = true;
		return this;
	}

	public CommonDialog setNegativeButton(String text, final OnClickCallback onClickCallback) {
		mNegativeView.setVisibility(View.VISIBLE);
		mNegativeView.setText(text);
		mNegativeView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dismiss();
				if (onClickCallback != null) {
					onClickCallback.onClick();
				}
			}
		});
		negativeShown = true;
		return this;
	}

	public CommonDialog setEditDrable(int drawableId) {
		mEditImageView.setVisibility(View.VISIBLE);
		mEditImageView.setImageResource(drawableId);
		return this;
	}

	public CommonDialog setEditable(boolean editable) {
		mEditLayout.setVisibility(View.VISIBLE);
		return this;
	}

	public CommonDialog setImageDrawableAndText(int drawableId, int textId) {
		mImageView.setVisibility(View.VISIBLE);
        mImageView.setText(context.getString(textId));
        Drawable drawable= context.getResources().getDrawable(drawableId);
        /// 这一步必须要做,否则不会显示.
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        mImageView.setCompoundDrawables(null, drawable, null, null);
        return this;
	}

	/**
	 * 设置可计数编辑框显示
	 * @param editable
	 * @return
	 */
	public CommonDialog setEditCountable(boolean editable) {
		if (editable) {
			mFameRemarkLayout.setVisibility(View.VISIBLE);
		}
		else {
			mFameRemarkLayout.setVisibility(View.GONE);
		}
		return this;
	}

	/**
	 * 对输入到mRemarkContentView中数据进行计数。
	 * @param _handler
	 * @return
	 */
	public CommonDialog setRemarkMessageHandler(Handler _handler){
		Message msg = Message.obtain();
		msg.obj		= mRemarkContentView;
		_handler.sendMessage(msg);
		return this;
	}

	public CommonDialog isPassword(boolean isPassword) {
		if (isPassword) {
			mContentView.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
		}
		return this;
	}

	public CommonDialog setHint(String hint) {
		mContentView.setHint(hint);
		return this;
	}

	public CommonDialog setText(String text) {
		mContentView.setText(text);
		return this;
	}

	public CommonDialog setInputType(int type) {
		mContentView.setInputType(type);
		return this;
	}

	public String getContent() {
		return mContentView.getText().toString();
	}
	/**
	 * 得到可计数编辑框中输入的内容
	 * @return
	 */
	public String getRemarkContent() {
		return mRemarkContentView.getText().toString();
	}

	@SuppressLint("InflateParams")
	public CommonDialog setSingleSelect(String[] select, int selectPosition, final OnItemSelectCallback onItemSelectCallback) {
		mSingleLayout.setVisibility(View.VISIBLE);
		for (int i = 0; i < select.length; i++) {
			if (i > 0) {
				TextView itemDivide = new TextView(context);
				itemDivide.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 3));
				itemDivide.setBackgroundColor(0xFFDDDDDD);
				mSingleLayout.addView(itemDivide);
			}
			View singleItem = LayoutInflater.from(context).inflate(R.layout.common_dialog_item, null);
			TextView title = (TextView) singleItem.findViewById(R.id.tv_title);
			ImageView isSelect = (ImageView) singleItem.findViewById(R.id.iv_isselect);
			title.setText(select[i]);
			if (i == selectPosition) {
				mSingleLayout.setTag(singleItem);
				isSelect.setVisibility(View.VISIBLE);
			}
			else {
				isSelect.setVisibility(View.INVISIBLE);
			}
			singleItem.setTag(i);
			mSingleLayout.addView(singleItem);
			singleItem.setClickable(true);
			singleItem.setFocusable(true);
			singleItem.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					((RelativeLayout) mSingleLayout.getTag()).getChildAt(1).setVisibility(View.INVISIBLE);
					((RelativeLayout) v).getChildAt(1).setVisibility(View.VISIBLE);
					mSingleLayout.setTag(v);
					onItemSelectCallback.onItemSelect((Integer) v.getTag());
				}
			});
		}
		return this;
	}
	
	public interface OnClickCallback {
		void onClick();
	}
	
	public interface OnItemSelectCallback {
		void onItemSelect(int position);
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		
		mCountView.setText(String.format("%1$s/%2$s", s.length(), MainConstant.REMARK_CHARACTER_MAX_LEN));
	}

	@Override
	public void afterTextChanged(Editable s) {
		
	}
}
