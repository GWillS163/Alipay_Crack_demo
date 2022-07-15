package com.example.alipay_balance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_my;
    Button btn_turn_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // 暂时直接跳转到这里
//        Intent intent = new Intent(MainActivity.this, activity_my.class);
//        startActivity(intent);

        btn_my = findViewById(R.id.my);
        btn_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(MainActivity.this, activity_my.class);
                startActivity(intent);
            }
        });
        btn_turn_money = findViewById(R.id.turn_money);
        btn_turn_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent = new Intent(MainActivity.this, turn_money.class);
                startActivity(intent);
            }
        });

    }
}
