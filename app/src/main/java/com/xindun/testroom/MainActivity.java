package com.xindun.testroom;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.UUID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {
  AppDatabase db;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database-name").build();

    //插入数据
    findViewById(R.id.insertButton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        new Thread(new Runnable() {
          @Override
          public void run() {
            db.userDao().insertAll(new User("chen", "love " + UUID.randomUUID()));
          }
        }).start();
      }
    });

    //删除数据
    findViewById(R.id.deleteButton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        new Thread(new Runnable() {
          @Override
          public void run() {

            for (User user : db.userDao().getAll()) {
              db.userDao().delete(user);
            }
          }
        }).start();
      }
    });

    //修改数据
    findViewById(R.id.update).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        new Thread(new Runnable() {
          @Override
          public void run() {
            for (User user : db.userDao().getAll()) {
              user.setFirstName("Android");
              db.userDao().update(user);
            }
          }
        }).start();
      }
    });

    //查询数据
    findViewById(R.id.querytButton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        new Thread(new Runnable() {
          @Override
          public void run() {
            for (User user : db.userDao().getAll()) {
              Log.i("query:", user.getFirstName() + user.getLastName());
            }
          }
        }).start();
      }
    });
  }
}
