package com.example.spda_app;

import android.Manifest;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;


import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.spda_app.databinding.SongSettingBinding;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SongSettingActivity extends AppCompatActivity {

    String filepath;
    private SongSettingBinding binding2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding2.getRoot());
        setTitle("노래추가");

        filepath = "/data/data/com.example.spda_app/files/Alarm_compilcation/awake_alarm.mp3";
        ActionBar actionBar = getSupportActionBar();

        requestAudioPermission();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
//        액션바를 이용한 방법
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
    }

    // audio 권한 요청
    private void requestAudioPermission() {
        if (isExternalStorageWritable() == true) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                checkSelfPermission(Manifest.permission.READ_MEDIA_AUDIO);
            } else {
                checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
        }
        else{
        }
    }

    // 외부 저장소 사용 가능 여부 판단
    public boolean isExternalStorageWritable(){
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Log.i("SongSettingActivity", "외부 사운드 읽기 쓰기 가능");
            return true;
        }
        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

//    액션바를 이용한 방법
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == android.R.id.home) {
//            onBackPressed(); // 기본 뒤로가기 동작 실행
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
