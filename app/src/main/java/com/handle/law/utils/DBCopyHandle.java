package com.handle.law.utils;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/5/1.
 */
public class DBCopyHandle {
    /**
     * path 把数据库拷贝到data/data/com.tiantan.phonesafe/files/address.db
     */
    public static boolean copyDB2AppFileSystem(Context _mContext, String _dbName) {
        try {
            File file = new File(_mContext.getFilesDir(), _dbName);
            if (file.exists() && file.length() > 0) {
                //正常了，就不需要拷贝了
                return false;
            }
            else {
                InputStream inputStream = _mContext.getResources().getAssets().open(_dbName);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, len);
                }
                inputStream.close();
                fileOutputStream.close();
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
