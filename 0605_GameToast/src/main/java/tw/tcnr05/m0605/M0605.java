package tw.tcnr05.m0605;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M0605 extends AppCompatActivity {


    private String user_select;
    private String answer;
    private TextView txtSelect;
    private TextView txtResult;
    private ImageView txtComPlay;
    private ImageButton Scissors;
    private ImageButton Stone;
    private ImageButton Net;
    private MediaPlayer musichaha;
    private MediaPlayer musiclose;
    private MediaPlayer musicvctory;
    private MediaPlayer startmusic;
    private MediaPlayer endmusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0605);

        setupViewComponent();


    }

    private void setupViewComponent() {
        //---取得R.java 配置碼----
        txtComPlay = (ImageView) findViewById(R.id.m0605_c001);
        txtSelect = (TextView) findViewById(R.id.m0605_s001);
        txtResult = (TextView) findViewById(R.id.m0605_f000);
        Scissors = (ImageButton) findViewById(R.id.m0605_b001);
        Stone = (ImageButton) findViewById(R.id.m0605_b002);
        Net = (ImageButton) findViewById(R.id.m0605_b003);

        //---啟動監聽事件---
        Scissors.setOnClickListener(buttonOn);
        Stone.setOnClickListener(buttonOn);
        Net.setOnClickListener(buttonOn);

        // --開啟片頭音樂-----
        // startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
        //startmusic.start();
        startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
        startmusic.start();

        musichaha = MediaPlayer.create(getApplication(), R.raw.haha);
        musiclose = MediaPlayer.create(getApplication(), R.raw.lose);
        musicvctory = MediaPlayer.create(getApplication(), R.raw.vctory);
        endmusic = MediaPlayer.create(getApplication(), R.raw.goodnight);
    }


    private View.OnClickListener buttonOn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3 + 1);
            switch (v.getId()) {
                case R.id.m0605_b001:   //選擇剪刀  scissors
                    user_select = getString(R.string.m0605_s001) + " " + getString(R.string.m0605_b001);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);//電腦選剪刀
                            answer = getString(R.string.m0605_f000) + getString(R.string.m0605_f003);//平


                            txtResult.setTextColor(Color.YELLOW);
                            music(1);

                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);//電腦選石頭
                            answer = getString(R.string.m0605_f000) + getString(R.string.m0605_f002);//輸
                            txtResult.setTextColor(Color.RED);
                            music(2);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);////電腦選布
                            answer = getString(R.string.m0605_f000) + getString(R.string.m0605_f001);//贏
                            txtResult.setTextColor(Color.GREEN);
                            music(3);
                            break;
                    }
                    break;
                //----------------------------------------------------

                case R.id.m0605_b002:   //我選擇石頭  stone
                    user_select = getString(R.string.m0605_s001) + "" + getString(R.string.m0605_b002);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);//電腦選剪刀
                            answer = getString(R.string.m0605_f000) + getString(R.string.m0605_f001);//贏
                            txtResult.setTextColor(Color.GREEN);
                            music(3);
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);//電腦選石頭
                            answer = getString(R.string.m0605_f000) + getString(R.string.m0605_f003);//平
                            txtResult.setTextColor(Color.YELLOW);
                            music(1);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);////電腦選布
                            answer = getString(R.string.m0605_f000) + getString(R.string.m0605_f002);//輸
                            txtResult.setTextColor(Color.RED);
                            music(2);
                            break;
                    }
                    break;
                //-----------------------------------------------

                case R.id.m0605_b003:   //我選擇布  net
                    user_select = getString(R.string.m0605_s001) + " " + getString(R.string.m0605_b003);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);//電腦選剪刀
                            answer = getString(R.string.m0605_f000) + getString(R.string.m0605_f002);//輸
                            txtResult.setTextColor(Color.RED);
                            music(2);
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);//電腦選石頭
                            answer = getString(R.string.m0605_f000) + getString(R.string.m0605_f001);//贏
                            txtResult.setTextColor(Color.GREEN);
                            music(3);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);////電腦選布
                            answer = getString(R.string.m0605_f000) + getString(R.string.m0605_f003);//平
                            txtResult.setTextColor(Color.YELLOW);
                            music(1);
                            break;
                    }
                    break;
            }
            txtSelect.setText(user_select);
            txtResult.setText(answer);
        }



    };

    private void music(int i) {
        if (startmusic.isPlaying()) startmusic.stop();
        if (musichaha.isPlaying()) musichaha.pause();
        if (musiclose.isPlaying()) musiclose.pause();
        if (musicvctory.isPlaying()) musicvctory.pause();

        switch (i) {
            case 1:

                musichaha.start();
                Toast.makeText(getApplicationContext(), R.string.m0605_f003 ,Toast.LENGTH_SHORT).show();
                break;
            case 2:

                musiclose.start();
                Toast.makeText(getApplicationContext(), R.string.m0605_f002 ,Toast.LENGTH_SHORT).show();
                break;
            case 3:

                musicvctory.start();
                Toast.makeText(getApplicationContext(), R.string.m0605_f001 ,Toast.LENGTH_SHORT).show();
                break;


            case 4:
                endmusic.start();
                break;
        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        music(4);

    }
}







