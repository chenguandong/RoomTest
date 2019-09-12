package com.xindun.testroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @author Administrator
 * @date 2019/9/11
 * @desc
 * @email chenguandong@outlook.com
 */
@Database(entities = { User.class }, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
  public abstract UserDao userDao();
}