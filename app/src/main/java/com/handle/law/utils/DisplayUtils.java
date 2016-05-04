package com.handle.law.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

import java.io.IOException;
import java.io.InputStream;

public class DisplayUtils {
	private static BitmapFactory.Options opt = null;
	
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	public static int getScreenWidth(Context context) {
		return context.getResources().getDisplayMetrics().widthPixels;
	}

	public static int getScreenHeight(Context context) {
		return context.getResources().getDisplayMetrics().heightPixels;
	}
	
	public static int sp2px(Context context, float spValue) { 
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity; 
        return(int) (spValue * fontScale + 0.5f); 
    }
	

	private static BitmapFactory.Options getBitmapOpt() {
		if(opt == null) {
			opt = new BitmapFactory.Options();

			opt.inPreferredConfig = Bitmap.Config.RGB_565;

			opt.inPurgeable = true;

			opt.inInputShareable = true;
		}
		return opt;
	}
	//获取资源图片
	public static BitmapDrawable getBitmapDrawable(Context _context, int _resId) {
		InputStream is = _context.getResources().openRawResource(_resId);

		Bitmap bitmap = BitmapFactory.decodeStream(is,null, getBitmapOpt());

		try {
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new BitmapDrawable(_context.getResources(), bitmap);
	}
}
