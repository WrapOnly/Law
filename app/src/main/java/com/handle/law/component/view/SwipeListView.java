
package com.handle.law.component.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.handle.law.R;

public class SwipeListView extends ListView {
    private Boolean mIsHorizontal;

    private View mPreItemView;

    private View mCurrentItemView;

    private float mFirstX;

    private float mFirstY;

    private int mRightViewWidth;

    // private boolean mIsInAnimation = false;
    private final int mDuration = 100;

    private final int mDurationStep = 10;

    private boolean mIsShown;

	private boolean flag = false;

	private OnItemDeleteListener onItemDeleteListener;

	private boolean isMove = false;

    public SwipeListView(Context context) {
        this(context,null);
    }

    public SwipeListView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SwipeListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,  
                R.styleable.swipelistviewstyle);
		//获取自定义属性和默认值  
		mRightViewWidth = (int) mTypedArray.getDimension(R.styleable.swipelistviewstyle_right_width, 200);   
		mTypedArray.recycle();  
    }

    /**
     * return true, deliver to listView. return false, deliver to child. if
     * move, return true
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        float lastX = ev.getX();
        float lastY = ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mIsHorizontal = null;
                mFirstX = lastX;
                mFirstY = lastY;
                int motionPosition = pointToPosition((int)mFirstX, (int)mFirstY);
                mPreItemView = mCurrentItemView;
                if (motionPosition >= 0) {
                    View currentItemView = getChildAt(motionPosition - getFirstVisiblePosition()).findViewWithTag("LinearLayout");
                    mCurrentItemView = currentItemView;
                } else {
					mCurrentItemView = null;
				}
                break;

            case MotionEvent.ACTION_MOVE:
                float dx = lastX - mFirstX;
                float dy = lastY - mFirstY;

                if (Math.abs(dx) >= 5 && Math.abs(dy) <= 5) {
                    return true;
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (mIsShown && (mPreItemView != mCurrentItemView || isHitCurItemLeft(lastX))) {
                    hiddenRight(mPreItemView);
                }
                break;
        }

        return super.onInterceptTouchEvent(ev);
    }

    private boolean isHitCurItemLeft(float x) {
        return x < getWidth() - mRightViewWidth;
    }
    
    /**
     * @param dx
     * @param dy
     * @return judge if can judge scroll direction
     */
    private boolean judgeScrollDirection(float dx, float dy) {
        boolean canJudge = true;

        if (Math.abs(dx) > 30 && Math.abs(dx) > 2 * Math.abs(dy)) {
            mIsHorizontal = true;
        } else if (Math.abs(dy) > 30 && Math.abs(dy) > 2 * Math.abs(dx)) {
            mIsHorizontal = false;
        } else {
            canJudge = false;
        }
        return canJudge;
    }

    /**
     * return false, can't move any direction. return true, cant't move
     * vertical, can move horizontal. return super.onTouchEvent(ev), can move
     * both.
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        flag = false;
        float lastX = ev.getX();
        float lastY = ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_MOVE:
                float dx = lastX - mFirstX;
                float dy = lastY - mFirstY;
                if (mIsHorizontal == null) {
                    if (!judgeScrollDirection(dx, dy)) {
                        flag = true;
                        break;
                    }
                }
                if (mIsHorizontal) {
                    if (mIsShown && mPreItemView != mCurrentItemView) {
                        flag = true;
                        break;
                    }
                    if (mIsShown && mPreItemView == mCurrentItemView) {
                        isMove = true;
                        dx = dx - mRightViewWidth;
                    }
                    if (dx < 0 && dx > -mRightViewWidth) {
                        if (mCurrentItemView != null) {
                            mCurrentItemView.scrollTo((int) (-dx), 0);
                        }
                    }
                    return true;
                } else {
                    if (mIsShown) {
                        /**
                         * 情况1：
                         * <p>
                         * 一个Item的右边布局已经显示，
                         * <p>
                         * 这时候上下滚动ListView,那么那个右边布局显示的item隐藏其右边布局
                         */
                        flag = true;
                        break;
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (mIsShown && !isMove) {
                    /**
                     * 情况2：
                     * <p>
                     * 一个Item的右边布局已经显示，
                     * <p>
                     * 这时候点击任意一个item，或者滑动其它item时，隐藏之
                     */
                    hiddenRight(mPreItemView);
                    isMove = false;
                    return true;
                }
                if (mIsHorizontal != null && mIsHorizontal) {
                    if (mFirstX - lastX > mRightViewWidth / 2) {
                        showRight(mCurrentItemView);
                    } else {
                        /**
                         * 情况3：
                         * <p>
                         * 向右滑动一个item,且滑动的距离超过了右边View的宽度的一半，隐藏之。
                         */
                        hiddenRight(mCurrentItemView);
                    }
                    isMove = false;
                    return true;
                }
                break;
        }
        return flag || super.onTouchEvent(ev);
    }

    private void showRight(View view) {
    	if (view == null) {
			return;
		}
        Message msg = new MoveHandler().obtainMessage();
        msg.obj = view;
        msg.arg1 = view.getScrollX();
        msg.arg2 = mRightViewWidth;
        msg.sendToTarget();

        mIsShown = true;
    }

    public void hiddenRight(View view) {
        if (view == null) {
            return;
        }
        Message msg = new MoveHandler().obtainMessage();//
        msg.obj = view;
        msg.arg1 = view.getScrollX();
        msg.arg2 = 0;

        msg.sendToTarget();

        mIsShown = false;
        flag = false;
    }

    /**
     * show or hide right layout animation
     */
    @SuppressLint("HandlerLeak")
    class MoveHandler extends Handler {
        int stepX = 0;

        int fromX;

        int toX;

        View view;

        private boolean mIsInAnimation = false;

        private void animatioOver() {
            mIsInAnimation = false;
            stepX = 0;
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (stepX == 0) {
                if (mIsInAnimation) {
                    return;
                }
                mIsInAnimation = true;
                view = (View)msg.obj;
                fromX = msg.arg1;
                toX = msg.arg2;
                stepX = (int)((toX - fromX) * mDurationStep * 1.0 / mDuration);
                if (stepX < 0 && stepX > -1) {
                    stepX = -1;
                } else if (stepX > 0 && stepX < 1) {
                    stepX = 1;
                }
                if (Math.abs(toX - fromX) < 10) {
                    view.scrollTo(toX, 0);
                    animatioOver();
                    return;
                }
            }

            fromX += stepX;
            boolean isLastStep = (stepX > 0 && fromX > toX) || (stepX < 0 && fromX < toX);
            if (isLastStep) {
                fromX = toX;
            }

            view.scrollTo(fromX, 0);
            invalidate();

            if (!isLastStep) {
                this.sendEmptyMessageDelayed(0, mDurationStep);
            } else {
                animatioOver();
            }
        }
    }

    public int getRightViewWidth() {
        return mRightViewWidth;
    }

    public void setRightViewWidth(int mRightViewWidth) {
        this.mRightViewWidth = mRightViewWidth;
    }

	public void delete(View view) {
		view.findViewWithTag("LinearLayout").scrollTo(0, 0);
		mIsShown = false;
		flag = false;
	}
	
	public void deleteItem(final View itemView, final int position) {
		final ViewGroup.LayoutParams lp = itemView.getLayoutParams();//获取item的布局参数
		final int originalHeight = itemView.getHeight();//item的高度

		ValueAnimator animator = ValueAnimator.ofInt(originalHeight, 0).setDuration(200);
		animator.start();

		
		animator.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				delete(itemView);
				if (onItemDeleteListener != null) {
					onItemDeleteListener.onDeleteListViewItem(position);
				}
			}
		});

		animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator valueAnimator) {
				//这段代码的效果是ListView删除某item之后，其他的item向上滑动的效果
				lp.height = (Integer) valueAnimator.getAnimatedValue();
				itemView.setLayoutParams(lp);
			}
		});
	}
	
	public void setOnItemDeleteListener(OnItemDeleteListener onItemDeleteListener) {
		this.onItemDeleteListener = onItemDeleteListener;
	}
	
	public interface OnItemDeleteListener {
		void onDeleteListViewItem(int position);
	}
	
}
