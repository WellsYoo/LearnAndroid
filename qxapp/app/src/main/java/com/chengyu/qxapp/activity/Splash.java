package com.chengyu.qxapp.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chengyu.qxapp.MainActivity;
import com.chengyu.qxapp.R;
import com.chengyu.qxapp.bean.User;

import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;

public class Splash  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);  //Option + Enter 自动生成布局文件

        //延时操作
        Timer timer = new Timer();
        timer.schedule(timeTask,2000);

        Bmob.initialize(this, "9dc879f7d59d48a9fa34054ecf0578e3");
    }

    TimerTask timeTask = new TimerTask() {
        @Override
        public void run() {
//            startActivity(new Intent(Splash.this, MainActivity.class));
            BmobUser bmobUser = BmobUser.getCurrentUser(User.class);
            if (bmobUser != null) {
                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();
            } else  {
                startActivity(new Intent(Splash.this, Login.class));
                finish();
            }
        }
    };
}


