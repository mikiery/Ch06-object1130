package tw.tcnr05.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0501 extends AppCompatActivity {



    private EditText e001;
    private Button b001;
    private Spinner s001;
    private TextView ans01;
    private String sSex;
    private String BB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0501);
        //setupViewcomponent();
        setupViewcomponet();
    }

    private void setupViewcomponet() {


        Intent intent=this.getIntent();
      BB=intent.getStringExtra("aa");
        this.setTitle(BB);




       e001 = (EditText) findViewById(R.id.m0501_e001);
        b001 = (Button) findViewById(R.id.m0501_b001);
        s001 = (Spinner) findViewById(R.id.m0501_s001);
        ans01 = (TextView) findViewById(R.id.m0501_f000);

        b001.setOnClickListener(b001on);

        // 設定 spinner item 選項------------
        // ArrayAdapter<CharSequence> adapSexList = ArrayAdapter
        // .createFromResource 帶三個參數(this, R.array.m0501_a001 // ,android.R.layout.simple_spinner_item);a  context 輸入this就好
        // dapSexList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);s001.setAdapter(adapSexList);
//---------------------------------------
        ArrayAdapter<CharSequence> adapterSexList =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.m0501_a001,
                        R.layout.support_simple_spinner_dropdown_item);
        s001.setAdapter(adapterSexList);
        s001.setOnItemSelectedListener(S001on); //手動設定(S001on)

    }


    private AdapterView.OnItemSelectedListener S001on = new AdapterView.OnItemSelectedListener() {
        // 選擇OnItemSelectedListener 意味著 監聽選擇Onltem指令
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sSex = parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    private View.OnClickListener b001on = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String stsug = getString(R.string.m0501_f000);
//------------------------------------------------------------------------------------------------

//檢查年齡是否輸入
            if (e001.getText().toString().length() > 0) {
                int iAge = Integer.parseInt(e001.getText().toString());

                //---男生-----
                if (sSex.equals(getString(R.string.chk01))) {
                    if (iAge < 28) {
                        stsug += getString(R.string.m0501_f001);
                    } else if (iAge > 33) {
                        stsug += getString(R.string.m0501_f003);
                    } else {
                        stsug += getString(R.string.m0501_f002);
                    }

                } else {
                    // ----女生-----
                    if (iAge < 25) {
                        stsug += getString(R.string.m0501_f001);
                    } else if (iAge > 30) {
                        stsug += getString(R.string.m0501_f003);
                    } else {
                        stsug += getString(R.string.m0501_f002);
                    }
                }


            } else {
                stsug = getString(R.string.nospace);
            }


            ans01.setText(stsug);
        }
    };
}