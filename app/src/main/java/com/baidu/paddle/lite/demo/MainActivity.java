package com.baidu.paddle.lite.demo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout v_img_classify = findViewById(R.id.v_img_classify);
        RelativeLayout v_obj_detect = findViewById(R.id.v_obj_detect);
        v_img_classify.setOnClickListener(this);
        v_obj_detect.setOnClickListener(this);
        // clear all setting items to avoid app crashing due to the incorrect settings
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.v_img_classify: {
                Intent intent = new Intent(MainActivity.this, ImgClassifyActivity.class);
                startActivity(intent);
            } break;
            case R.id.v_obj_detect: {
                Intent intent = new Intent(MainActivity.this, ObjDetectActivity.class);
                startActivity(intent);
            } break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }
}
