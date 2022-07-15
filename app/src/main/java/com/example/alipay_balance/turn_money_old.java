////参考 https://blog.csdn.net/qq_41113081/article/details/86690615
//package com.example.alipay_balance;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import java.io.IOException;
//
//public class turn_money extends AppCompatActivity implements View.OnClickListener {
//    private Button turn_btn;
////    private Button start;
////    private Button pause;
//
//    private MediaPlayer mediaPlayer;
//
//    public void play_video(){
//
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_turn_money);
//
//        EditText input_money_edt = findViewById(R.id.input_money);
//        String turn_money1 = input_money_edt.getText().toString();
//
//    }
//    private void play_video(String tts_path){
//        init();
//        initMediaPlayer(tts_path);
//        if (!mediaPlayer.isPlaying()) {
//            mediaPlayer.start();
//        }
//        super.onDestroy();
//        if (mediaPlayer != null) {
//            mediaPlayer.stop();
//            mediaPlayer.release();
//        }
//    }
//    private void initMediaPlayer(String input_money) {
//        try {
////            mediaPlayer.setDataSource("http://www.ytmp3.cn/down/57799.mp3");
//            mediaPlayer.setDataSource("@tts/tts_0.mp3");
////            mediaPlayer.setDataSource("https://mm.cqu.cc/share/zhifubaodaozhang/?money=" + input_money);
////            mediaPlayer.setDataSource("D:\\System\\Music\\Minecraft-伤害.mp3");
//            mediaPlayer.prepare();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void init() {
//        turn_btn = findViewById(R.id.turn_btn);
//        turn_btn.setOnClickListener(this);
//        mediaPlayer = new MediaPlayer();
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.turn_btn:
//                EditText input_money_edt = findViewById(R.id.input_money);
//                String turn_money1 = input_money_edt.getText().toString();
////                Toast.makeText(this, turn_money1,Toast.LENGTH_SHORT).show();
////                String turn_money = "10000000";
//
//                initMediaPlayer(turn_money1);
//                if (!mediaPlayer.isPlaying()) {
//                    mediaPlayer.start();
//                }
//                break;
//            case R.id.start:
//                if (!mediaPlayer.isPlaying()) {
//                    mediaPlayer.start();
//                }
//                break;
////            case R.id.pause:
////                if (mediaPlayer.isPlaying()) {
////                    mediaPlayer.pause();
////                }
////                break;
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (mediaPlayer != null) {
//            mediaPlayer.stop();
//            mediaPlayer.release();
//        }
//    }
//}
//
