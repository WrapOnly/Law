package com.handle.law.base;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v4.app.Fragment;

import java.util.List;

public abstract class BaseFragment extends Fragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		WebuyApp.currentActivity = getActivity();
	}
	
	@Override
	public void onResume() {
		super.onResume();
//		WebuyApp.currentActivity = getActivity();
		
//		WebuyApp.getInstance(BaseFragment.this.getActivity()).handleForegroundEvnent(true);
//		StatService.onResume(this);
	} 
	
	@Override
	public void onPause() {
		super.onPause();
//		StatService.onPause(this);
	}

	@Override
	public void onStop() {
		super.onStop();
		if (!isAppOnForeground()) {
            //app 进入后台
//			WebuyApp.currentActivity = null;
//			WebuyApp.getInstance(BaseFragment.this.getActivity()).handleForegroundEvnent(false);
		}
	}
	
	public boolean isAppOnForeground() {
        // Returns a list of application processes that are running on the
        // device
         
        ActivityManager activityManager = (ActivityManager) getActivity().getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = getActivity().getApplicationContext().getPackageName();

        List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
        	return false;
        }
        
        PowerManager pm = (PowerManager) getActivity().getApplicationContext().getSystemService(Context.POWER_SERVICE);
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
