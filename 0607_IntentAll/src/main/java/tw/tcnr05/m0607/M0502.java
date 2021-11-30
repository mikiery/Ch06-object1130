package tw.tcnr05.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0502 extends AppCompatActivity {


    //private EditText e001;
    private Button b001;
    //private Spinner s001;
    private TextView ans01;
    private String sSex;
    private RadioGroup rb01;
    private RadioGroup rb02;
    private RadioButton rb021;
    private RadioButton rb022;
    private RadioButton rb023;
    private String cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0502);
        setViewcomponent();

//        setupViewcomponet();
    }

    private void setViewcomponent() {
        Intent intent=this.getIntent();
        cc=intent.getStringExtra("bb");
        this.setTitle(cc);



        ans01 = (TextView) findViewById(R.id.m0502_f000);
        b001 = (Button) findViewById(R.id.m0502_b001); //建議

        rb01 = (RadioGroup) findViewById(R.id.m0502_r001);    //性別
        rb02 = (RadioGroup) findViewById(R.id.m0502_r002);   //年齡
        rb021 = (RadioButton) findViewById(R.id.m0502_r002a);
        rb022 = (RadioButton) findViewById(R.id.m0502_r002b);
        rb023 = (RadioButton) findViewById(R.id.m0502_r002c);

        b001.setOnClickListener(b001on);
        rb01.setOnCheckedChangeListener(rb01on);
    }

    private RadioGroup.OnCheckedChangeListener rb01on = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int i) {

            switch (i) {
                case R.id.m0502_r001a:
                    rb021.setText(R.string.m0502_r002aa);
                    rb022.setText(R.string.m0502_r002ab);
                    rb023.setText(R.string.m0502_r002ac);

                    break;
                case R.id.m0502_r001b:

                    rb021.setText(R.string.m0502_r002ba);
                    rb022.setText(R.string.m0502_r002bb);
                    rb023.setText(R.string.m0502_r002bc);
                    break;

            }
        }
    };

    private View.OnClickListener b001on = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String strsung = getString(R.string.m0502_f000);
            int ichksex = rb01.getCheckedRadioButtonId();

            switch (ichksex) {
                case R.id.m0502_r001a:
                    switch (rb02.getCheckedRadioButtonId()) {
                        case R.id.m0502_r002a:
                            strsung += getString(R.string.m0502_f001);
                            break;
                        case R.id.m0502_r002b:
                            strsung += getString(R.string.m0502_f002);
                            break;
                        case R.id.m0502_r002c:
                            strsung += getString(R.string.m0502_f003);
                            break;
                    }
                    break;
                case R.id.m0502_r001b:
                    switch (rb02.getCheckedRadioButtonId()) {
                        case R.id.m0502_r002a:
                            strsung += getString(R.string.m0502_f004);
                            break;
                        case R.id.m0502_r002b:
                            strsung += getString(R.string.m0502_f005);
                            break;
                        case R.id.m0502_r002c:
                            strsung += getString(R.string.m0502_f006);
                            break;
                    }
                    break;
            }

            ans01.setText(strsung);

        }


    };
}

//
//    private void setupViewcomponet() {
//
//
//
//        b001.setOnClickListener(b001on);
//
//        // 設定 spinner item 選項------------
//        // ArrayAdapter<CharSequence> adapSexList = ArrayAdapter
//        // .createFromResource 帶三個參數(this, R.array.m0502_a001 // ,android.R.layout.simple_spinner_item);a  context 輸入this就好
//        // dapSexList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);s001.setAdapter(adapSexList);
////---------------------------------------
//        ArrayAdapter<CharSequence> adapterSexList =
//                ArrayAdapter.createFromResource(
//                        this,
//                        R.array.m0502_a001,
//                        R.layout.support_simple_spinner_dropdown_item);
//        s001.setAdapter(adapterSexList);
//        s001.setOnItemSelectedListener(S001on); //手動設定(S001on)
//
//    }
//
//
//    private AdapterView.OnItemSelectedListener S001on = new AdapterView.OnItemSelectedListener() {
//        // 選擇OnItemSelectedListener 意味著 監聽選擇Onltem指令
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//            sSex = parent.getSelectedItem().toString();
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//    };
//    private View.OnClickListener b001on = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {

////------------------------------------------------------------------------------------------------
//
////檢查年齡是否輸入
//            if (e001.getText().toString().length() > 0) {
//                int iAge = Integer.parseInt(e001.getText().toString());
//
//                //---男生-----
//                if (sSex.equals(getString(R.string.chk01))) {
//                    if (iAge < 28) {
//                        stsug += getString(R.string.m0502_f001);
//                    } else if (iAge > 33) {
//                        stsug += getString(R.string.m0502_f003);
//                    } else {
//                        stsug += getString(R.string.m0502_f002);
//                    }
//
//                } else {
//                    // ----女生-----
//                    if (iAge < 25) {
//                        stsug += getString(R.string.m0502_f001);
//                    } else if (iAge > 30) {
//                        stsug += getString(R.string.m0502_f003);
//                    } else {
//                        stsug += getString(R.string.m0502_f002);
//                    }
//                }
//
//
//            } else {
//                stsug = getString(R.string.nospace);
//            }
//
//
//            ans01.setText(stsug);
//        }
//    };
