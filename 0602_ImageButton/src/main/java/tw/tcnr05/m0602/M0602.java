package tw.tcnr05.m0602;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0602 extends AppCompatActivity {


    private String user_select;
    private String answer;
    private TextView txtSelect;
    private TextView txtResult;
    private ImageView txtComPlay;
    private ImageButton Scissors;
    private ImageButton Stone;
    private ImageButton Net;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0602);

        setupViewComponent();
    }

    private void setupViewComponent() {
        //---取得R.java 配置碼----
        txtComPlay = (ImageView) findViewById(R.id.m0602_c001);
        txtSelect = (TextView) findViewById(R.id.m0602_s001);
        txtResult = (TextView) findViewById(R.id.m0602_f000);
        Scissors = (ImageButton) findViewById(R.id.m0602_b001);
        Stone = (ImageButton) findViewById(R.id.m0602_b002);
        Net = (ImageButton) findViewById(R.id.m0602_b003);

        //---啟動監聽事件---
        Scissors.setOnClickListener(buttonOn);
        Stone.setOnClickListener(buttonOn);
        Net.setOnClickListener(buttonOn);

    }


    private View.OnClickListener buttonOn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3 + 1);
            switch (v.getId()) {
                case R.id.m0602_b001:   //選擇剪刀  scissors
                    user_select = getString(R.string.m0602_s001) + " " + getString(R.string.m0602_b001);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);//電腦選剪刀
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f003);//平
                            txtResult.setTextColor(Color.YELLOW);

                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);//電腦選石頭
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f002);//輸
                            txtResult.setTextColor(Color.RED);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);////電腦選布
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f001);//贏
                            txtResult.setTextColor(Color.GREEN);
                            break;
                    }
                    break;
                //----------------------------------------------------

                case R.id.m0602_b002:   //我選擇石頭  stone
                    user_select = getString(R.string.m0602_s001) + "" + getString(R.string.m0602_b002);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);//電腦選剪刀
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f001);//贏
                            txtResult.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);//電腦選石頭
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f003);//平
                            txtResult.setTextColor(Color.YELLOW);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);////電腦選布
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f002);//輸
                            txtResult.setTextColor(Color.RED);
                            break;
                    }
                    break;
                //-----------------------------------------------

                case R.id.m0602_b003:   //我選擇布  net
                    user_select = getString(R.string.m0602_s001) + " " + getString(R.string.m0602_b003);
                    switch (iComPlay) {
                        case 1:
                            txtComPlay.setImageResource(R.drawable.scissors);//電腦選剪刀
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f002);//輸
                            txtResult.setTextColor(Color.RED);
                            break;
                        case 2:
                            txtComPlay.setImageResource(R.drawable.stone);//電腦選石頭
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f001);//贏
                            txtResult.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            txtComPlay.setImageResource(R.drawable.net);////電腦選布
                            answer = getString(R.string.m0602_f000) + getString(R.string.m0602_f003);//平
                            txtResult.setTextColor(Color.YELLOW);
                            break;
                    }
                    break;
            }
            txtSelect.setText(user_select);
            txtResult.setText(answer);
        }
    };
}







