package com.example.alipay_balance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class turn_money extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    Button turn_btn;
    public Boolean flag = Boolean.FALSE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_money);
        turn_btn = findViewById(R.id.turn_btn);
        turn_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String res;
                EditText input_money = findViewById(R.id.input_money);
                try{
                    int input_money_num = Integer.parseInt(input_money.getText().toString());
                    ConverToChinesePart conver = new ConverToChinesePart(input_money_num);
                    res = conver.convertToChinese();}
                catch (Exception e){
                    e.printStackTrace();
                    res = "一百万元";
                }
                System.out.println("已到账"+res);
                Toast.makeText(turn_money.this, "尝试转账:" +  res, Toast.LENGTH_SHORT).show();
                // 0. 模拟成果
                play_video('测');
                // 1. 用 onCompeltionListener 监听音频
//                play_video('到');
//                for (int i = 0; i < res.length(); i++) {
//                    // TODO: 如何检测到上一个音频播放后再播放下一个音频
//                    waiting_play(res.charAt(i));
//                }

                //2. 直接播放所有音频
//                play_video('到');
//                for (int i = 0; i < res.length(); i++) {
//                    // TODO: 如何检测到上一个音频播放后再播放下一个音频
//                    play_video(res.charAt(i));
//                }


//                cmd("copy /b D:\\raw\\tts_0.mp3+D:\\raw\\tts_1.mp3 D:\\atarashii_auto_merge.mp3");
//                cmd("gpedit.msc");
//                play_video('到');
////                play_video('元');
//
//                //遍历中文, 例：二千三百二十三元
//                for (int i = 0; i < res.length(); i++) {
//                    play_video(res.charAt(i));
//
//                    //TODO: 需要加延迟！！！ java怎么搞！他妈的， 就不能time.sleep这么简单吗！
//                }
////                play_video('元');


            }
        });
    }
    public void waiting_play(final Character chr){
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                flag=Boolean.FALSE;
                System.out.println("已等到，正在播放:" + chr);
                play_video(chr);
                flag=Boolean.TRUE;
            }
        });
    }


    // 拼接后无法读取， 弃用
    public static boolean cmd(String command){
        boolean flag = false;
        try{
            Runtime.getRuntime().exec("cmd.exe /C start "+command);
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    // 直接播放合成文件
    public void play_merge_audio() throws IOException {

        if(mediaPlayer == null){
            //获取应用内的音乐文件
            final MediaPlayer mp = new MediaPlayer();
//            mp.setDataSource("D:\\atarashii_auto_merge.mp3");
            mp.setDataSource("D:\\atarashii.mp3");
            mp.start();
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mp.release();
                }
            });
        }
    }


    public void play_video(Character str){
        System.out.println("播放："+str);
        mediaPlayer = null;
//        if(mediaPlayer == null){
        //获取应用内的音乐文件
        switch (str) {
            case '测':
                mediaPlayer = MediaPlayer.create(this, R.raw.atarashii);
                break;
            case '到':
                mediaPlayer = MediaPlayer.create(this, R.raw.tts_success);
                break;
            case '一':
                mediaPlayer = MediaPlayer.create(this, R.raw.tts_1);
                break;
            case '二':
                mediaPlayer = MediaPlayer.create(this, R.raw.tts_2);
                break;
            case '十':
                mediaPlayer = MediaPlayer.create(this, R.raw.tts_ten);
                break;
            case '百':
                mediaPlayer = MediaPlayer.create(this, R.raw.tts_ten);
                break;
            case '千':
                mediaPlayer = MediaPlayer.create(this, R.raw.tts_thousand);
                break;
            case '万':
                mediaPlayer = MediaPlayer.create(this, R.raw.tts_ten_thousand);
                break;
            case '元':
                mediaPlayer = MediaPlayer.create(this, R.raw.tts_yuan);
                break;
        }
        assert mediaPlayer != null;
        mediaPlayer.start();

//        else{
////            mediaPlayer.stop();
////            if (mediaPlayer.isPlaying()) {
////            }
//            mediaPlayer.release();
//        }
//        else if(mediaPlayer.isPlaying()){
//            mediaPlayer.pause();
//        }
//        else{
//            mediaPlayer.start();
//        }
    }
    // 暂时弃用
    public void parse_num_and_play(View view) {
        Button imageButton = (Button)view;
        EditText input_money = findViewById(R.id.input_money);
        int input_money_num = Integer.parseInt(input_money.getText().toString());
        ConverToChinesePart conver = new ConverToChinesePart(input_money_num);
        String res = conver.convertToChinese();
        play_video('一');
        System.out.println("已到账"+res);


    }


    public void isPlayOrPause(View view){
        ImageButton imagebutton = (ImageButton) view;
        //RotateAnimation animation = new RotateAnimation(0, 360);
        //animation.setDuration(100000);
        //animation.setRepeatCount(Animation.INFINITE);
        //animation.setRepeatMode(Animation.RESTART);
        if(mediaPlayer == null){
            //imageButton.startAnimation(animation);
            //获取应用内的音乐文件
            mediaPlayer = MediaPlayer.create(this, R.raw.tts_success);
            mediaPlayer.start();
        }
        else if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            //imageButton.clearAnimation();
        }
        else{
            mediaPlayer.start();
            //imageButton.startAnimation(animation);
        }
    }

}