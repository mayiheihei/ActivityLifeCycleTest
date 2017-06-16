package com.example.activitylifecycletest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //关联主活动布局
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        //
        if(savedInstanceState !=null){
            String tempData = savedInstanceState.getString("data_key");
            Log.d(TAG, tempData);
        }

        //创建两个按钮
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);

        //重写普通按钮点击事件
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        //重写对话框按钮点击事件
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart***");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume*** ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause***");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop***");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy*** ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart*** ");
    }

    //停止状态缓存内容（存）
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "你刚刚输入的内容，不会丢失哦！";
        outState.putString("data_key",tempData);
    }
}
