package com.xindun.testroom;

import android.app.Application;
import android.content.Context;

import com.xindun.testroom.db.AppDatabase;

/**
 * @author Administrator
 * @date 2019/9/12
 * @desc
 * @email chenguandong@outlook.com
 */
public class MyApp extends Application {
  private static MyApp mInstance;

  @Override
  public Context getApplicationContext() {
    return super.getApplicationContext();
  }

  public static MyApp getInstance() {
    return mInstance;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    mInstance = this;
    AppDatabase.getInstance();
  }
}
