package com.example.alipay_balance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class activity_balance extends AppCompatActivity {
    DcTextViewRunNumber balance_num;
    Button add_money_btn;
    Button withdraw_money_btn;
    Button back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        balance_num = (DcTextViewRunNumber)findViewById(R.id.balance_num);
        back_btn = findViewById(R.id.balance_back);

        withdraw_money_btn = findViewById(R.id.withdraw_money);
        add_money_btn = findViewById(R.id.add_money);
        add_money_btn.setOnClickListener(new View.OnClickListener() {
            private DcTextViewRunNumber numberRunView;
            @Override
            public void onClick(View view) {
                balance_num.setShowNum("10000", 2);//终止的数字，小数点，这里为0所以没有小数点
                balance_num.setRunCount(11020);//动画执行的次数

                balance_num.startRun("10000");//
/*                for (int i = 0; i <10000 ; i++) {
//                    total += i/100;
//                    for (int j = 1; j < 40; j++) {
////                        double res2 =  Math.log(j);
//                        double res2 = Math.pow(j, 300);
//                    }
//                    // TODO: 增加time.sleep  Thread.sleep会卡住， 亟需解决
                    balance_num.setText(String.valueOf(i));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

//
//                    //TODO: 不能自动刷新
//
                }
                balance_num.setText("∞");*/

            }
        });
        withdraw_money_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity_balance.this, "禁止提现", Toast.LENGTH_SHORT).show();
            }
        });
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_balance.this, activity_my.class);
                startActivity(intent);
            }
        });

        //https://mm.cqu.cc/share/zhifubaodaozhang/mp3/88.88.mp3
    }
}


