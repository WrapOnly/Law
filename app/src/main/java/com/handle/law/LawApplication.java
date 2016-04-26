package com.handle.law;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationManager;
import android.util.Log;

/**
 * Created by Administrator on 2016/4/25.
 */
public class LawApplication extends Application {
    private static final String TAG = "LawApplication";

    private static LawApplication instance		 = null;
    public static Activity currentActivity 	  = null;
    public static boolean isFirstLogin          = true;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @Override
    public void onTerminate() {
        // TODO Auto-generated method stub
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(android.content.Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();
        super.onTerminate();
    }

    public static synchronized LawApplication getInstance() {
        if(instance == null) {
            Log.e(TAG, "LawApplication instance is null!");
            try {
                instance = (LawApplication) currentActivity.getApplication();
            }
            catch(Exception _e) {
                _e.printStackTrace();
            }
        }
        return instance;
    }

    public static synchronized LawApplication getInstance(Activity _activity) {
        if(instance == null) {
            Log.e(TAG, "LawApplication instance is null!");
            try {
                instance = (LawApplication) _activity.getApplication();
            }
            catch(Exception _e) {
                _e.printStackTrace();
            }
        }
        return instance;
    }
}
