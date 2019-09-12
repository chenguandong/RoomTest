package com.xindun.testroom;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author Administrator
 * @date 2019/9/11
 * @desc
 * @email chenguandong@outlook.com
 */
@Entity
public class User {
  @PrimaryKey(autoGenerate = true)
  private int uid;
  @ColumnInfo(name = "first_name")
  private String firstName;
  @ColumnInfo(name = "last_name")
  private String lastName;

  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  @NonNull
  @Override
  public String toString() {
    return "firstName="+firstName+"  last_name"+lastName;
  }
}
