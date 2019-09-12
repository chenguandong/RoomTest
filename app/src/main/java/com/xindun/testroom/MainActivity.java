package com.xindun.testroom;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.xindun.testroom.db.AppDatabase;
import com.xindun.testroom.db.entity.User;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    //插入数据
    findViewById(R.id.insertButton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        new Thread(new Runnable() {
          @Override
          public void run() {
            AppDatabase.getInstance().userDao().insertAll(new User("chen", "love " + UUID.randomUUID()));
            //AppDatabase.getInstance().userDao().insertAll(new User("chen", "love " + UUID.randomUUID(), new Random().nextInt
            // ()));
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

            for (User userDBEntity : AppDatabase.getInstance().userDao().getAll()) {
              AppDatabase.getInstance().userDao().delete(userDBEntity);
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
            for (User userDBEntity : AppDatabase.getInstance().userDao().getAll()) {
              userDBEntity.setFirstName("Android");
              AppDatabase.getInstance().userDao().update(userDBEntity);
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
            for (User userDBEntity : AppDatabase.getInstance().userDao().getAll()) {
              Log.i("query:", userDBEntity.getFirstName() + userDBEntity.getLastName()/*+ userDBEntity.getAge()*/);
            }
          }
        }).start();
      }
    });

















   /* //插入book数据
    findViewById(R.id.bookInsertButton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        new Thread(new Runnable() {
          @Override
          public void run() {
            AppDatabase.getInstance().bookDao().insertAll(new Book("book",1, 10000));
          }
        }).start();
      }
    });


    //查询book数据
    findViewById(R.id.bookQuerytButton).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        new Thread(new Runnable() {
          @Override
          public void run() {
            for (Book book : AppDatabase.getInstance().bookDao().getAll()) {
              Log.i("querybook:", book.getName() + book.getUid()+ book.getTime());
            }
          }
        }).start();
      }
    });*/
  }
}
