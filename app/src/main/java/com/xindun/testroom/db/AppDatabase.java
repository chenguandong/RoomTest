package com.xindun.testroom.db;

import com.xindun.testroom.MyApp;
import com.xindun.testroom.db.dao.UserDao;
import com.xindun.testroom.db.entity.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * @author Administrator
 * @date 2019/9/11
 * @desc
 * @email chenguandong@outlook.com
 */
@Database(entities = { User.class/*, Book.class */ }, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
  private static AppDatabase database;

  public static AppDatabase getInstance() {
    if (database == null) {
      synchronized (AppDatabase.class) {
        if (database == null) {
          database = Room.databaseBuilder(MyApp.getInstance().getApplicationContext(), AppDatabase.class, "database-name")
              //.addMigrations(MIGRATION_2_3)
              // .allowMainThreadQueries()
              .build();
        }
      }
    }
    return database;
  }

  public abstract UserDao userDao();
  //public abstract BookDao bookDao();
  /**
   * 数据库版本 1->2 user表格新增了age列
   */
  static final Migration MIGRATION_1_2 = new Migration(1, 2) {
    @Override
    public void migrate(SupportSQLiteDatabase database) {
      database.execSQL("ALTER TABLE user " + " ADD COLUMN age INTEGER");
    }
  };
  /**
   * 数据库版本 2->3 新增book表格
   */
  static final Migration MIGRATION_2_3 = new Migration(2, 3) {
    @Override
    public void migrate(SupportSQLiteDatabase database) {
      database.execSQL(
          "CREATE TABLE IF NOT EXISTS `book` (`uid` INTEGER PRIMARY KEY autoincrement, `name` TEXT , `user_id` INTEGER, 'time' "
              + "INTEGER)");
    }
  };
}