package tw.tcnr05.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class M0500 extends AppCompatActivity {   //宣告變數


    private Button b001;
    private TextView t003;
    private EditText e001;
    private DecimalFormat pondsformat; //整理放在這裡
    private String ans;
    private String AA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0500);
        setupViewcomponent();
    }

    private void setupViewcomponent() {

        Intent intent=this.getIntent();
        AA=intent.getStringExtra("00");  //Extra 傳遞參數
        this.setTitle(AA);




        e001=(EditText)findViewById(R.id.m0500_e001);

        b001=(Button)findViewById(R.id.m0500_b001);

        t003=(TextView)findViewById(R.id.m0500_t003);


        b001.setOnClickListener(b001on);
    }



    private View.OnClickListener b001on=new View.OnClickListener() {   //( = )意思是左邊物件給右邊物件  ( . ) 表示選擇屬性
        @Override
        public void onClick(View v) {
//            DecimalFormat   pondsFormat = new DecimalFormat("0.00000");


       pondsformat = new DecimalFormat("0.00000"); //宣告變數 pondsformatf前面紅燈泡 公開 第一層
            if (e001.getText().toString().length()>0){

                ans = pondsformat.format(Float.parseFloat(e001.getText().toString())*2.20462262);
            }else {
                ans="";
            }

            t003.setText(ans);

        }
    };

}