package com.example.administrator.activity;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.activity.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("MainActivity","onConfigurationChanged() is invoked！"+newConfig.orientation);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MainActivity","onPause() is invoked！");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MainActivity","onResume() is invoked！");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MainActivity","onStart() is invoked！");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MainActivity","onRestart() is invoked！");
    }

}
