package com.xindun.testroom;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * @author Administrator
 * @date 2019/9/11
 * @desc
 * @email chenguandong@outlook.com
 */
@Dao
public interface UserDao {
  @Query("SELECT * FROM user")
  List<User> getAll();

  @Query("SELECT * FROM user WHERE uid IN (:userIds)")
  List<User> loadAllByIds(int[] userIds);

  @Query("SELECT * FROM user WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
  User findByName(String first, String last);

  @Insert
  void insertAll(User... users);

  @Delete
  void delete(User user);

  @Update
  void update(User user);
}
