package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        title = findViewById(R.id.title_tv);
        title.setText("订单详情");
    }
    //统一定义单击返回按键执行操作
    public void backToMain(View view){
        onBackPressed();
    }
}
