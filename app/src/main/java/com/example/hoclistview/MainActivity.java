package com.example.hoclistview;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moManHinhListView1(View view) {
        Intent intent=new Intent(MainActivity.this,ListView1Activity.class);
        startActivity(intent);
    }

    public void moManHinhListView2(View view) {
        Intent intent=new Intent(MainActivity.this,ListView2Activity.class);
        startActivity(intent);
    }

    public void moManHinhListView3(View view) {
        Intent intent=new Intent(MainActivity.this,ListView3Activity.class);
        startActivity(intent);
    }
}
