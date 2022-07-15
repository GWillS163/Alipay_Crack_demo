package com.example.alipay_balance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_my extends AppCompatActivity {
    Button balance_btn;
    Button index_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        balance_btn = findViewById(R.id.my_balance);
        index_btn = findViewById(R.id.index);
        balance_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_my.this, activity_balance.class);
                startActivity(intent);

            }
        });
        index_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_my.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
