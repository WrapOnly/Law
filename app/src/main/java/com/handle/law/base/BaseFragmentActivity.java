package com.handle.law.base;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import java.util.List;

public abstract class BaseFragmentActivity extends FragmentActivity {
	
//	private FloatWindowReceiver receiver;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
//		WebuyApp.currentActivity = this;
//		initLanguage();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}
	
	/**init views*/
	protected abstract void initViews();
	
	/**register listener*/
	protected abstract void setListener();
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		if (!isAppOnForeground()) {
            //app 进入后台
//			WebuyApp.currentActivity = null;
		}
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	public boolean isAppOnForeground() {
        // Returns a list of application processes that are running on the
        // device
         
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();

        List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
        	return false;
        }
        
        PowerManager pm = (PowerManager) getApplicationContext().getSystemService(Context.POWER_SERVICE);
        if(!pm.isScreenOn()) {
        	return false;
        }
    
        for (RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
        	if (appProcess.processName.equals(packageName) && appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
            	return true;
            }
        }

        return false;
	}

}
