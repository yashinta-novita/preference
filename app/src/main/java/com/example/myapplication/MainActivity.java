package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button settingBtn = (Button)findViewById(R.id.settingBtn);
        settingBtn.setOnClickListener(mySettingBtnClick);
        SharedPreferences prefs = MainActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);

        String statusLogin = prefs.getString("isLogin",null); Button btnLogin = (Button)findViewById(R.id.loginBtn);
        btnLogin.setOnClickListener(myBtnLoginClick);

        if (statusLogin != null){
            btnLogin.setText("Logout");
        }else{
            btnLogin.setText("Login");
        }
    }

    private View.OnClickListener mySettingBtnClick = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        };
    };

    private View.OnClickListener myBtnLoginClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences prefs = MainActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);

            String statusLogin = prefs.getString("isLogin",null);
            SharedPreferences.Editor edit = prefs.edit();

        Button btnLogin = (Button)findViewById(R.id.loginBtn);
        if (statusLogin != null){
            edit.putString("isLogin",null);
            btnLogin.setText("Login");
        }else{
            edit.putString("isLogin","Admin");
            btnLogin.setText("Logout");
        }
        edit.commit();
        }
    };

    private View.OnClickListener myBtnSettingClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        };

        };
    }

