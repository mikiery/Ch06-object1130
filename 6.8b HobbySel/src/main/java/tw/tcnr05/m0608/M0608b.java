package tw.tcnr05.m0608;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0608b extends AppCompatActivity {

//      private CheckBox chb01, chb02, chb03, chb04, chb05;
//      private CheckBox chb06, chb07, chb08, chb09, chb10;
//      private CheckBox chb11, chb12, chb13, chb14, chb15;
//      private CheckBox chb16, chb17, chb18, chb19, chb20;

      private Button b001;
      private TextView t001;
//      private CheckBox[] checks;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.m0608);
            setViewComponent();
      }

      private void setViewComponent() {
//            chb01 = (CheckBox) findViewById(R.id.m0608_chb01);
//            chb02 = (CheckBox) findViewById(R.id.m0608_chb02);
//            chb03 = (CheckBox) findViewById(R.id.m0608_chb03);
//            chb04 = (CheckBox) findViewById(R.id.m0608_chb04);
//
//            chb05 = (CheckBox) findViewById(R.id.m0608_chb05);
//            chb06 = (CheckBox) findViewById(R.id.m0608_chb06);
//            chb07 = (CheckBox) findViewById(R.id.m0608_chb07);
//            chb08 = (CheckBox) findViewById(R.id.m0608_chb08);
//            chb09 = (CheckBox) findViewById(R.id.m0608_chb09);
//            chb10 = (CheckBox) findViewById(R.id.m0608_chb10);
//
//            chb11 = (CheckBox) findViewById(R.id.m0608_chb11);
//            chb12 = (CheckBox) findViewById(R.id.m0608_chb12);
//            chb13 = (CheckBox) findViewById(R.id.m0608_chb13);
//            chb14 = (CheckBox) findViewById(R.id.m0608_chb14);
//            chb15 = (CheckBox) findViewById(R.id.m0608_chb15);
//
//            chb16 = (CheckBox) findViewById(R.id.m0608_chb16);
//            chb17 = (CheckBox) findViewById(R.id.m0608_chb17);
//            chb18 = (CheckBox) findViewById(R.id.m0608_chb18);
//            chb19 = (CheckBox) findViewById(R.id.m0608_chb19);
//            chb20 = (CheckBox) findViewById(R.id.m0608_chb20);

            b001 = (Button) findViewById(R.id.m0608_b001);

            t001 = (TextView) findViewById(R.id.m0608_t001);

            b001.setOnClickListener(b001On);
      }

      private View.OnClickListener b001On = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  String ans = getString(R.string.m0608_t001);

                  for (int i = 1; i < 21; i++) {
                        String idName = "m0608_chb" + String.format("%02d", i);//String.format格式化"%02d"為顯示兩位(02)整數字(d)，自動補0
                        int resID = getResources().getIdentifier(idName, "id", getPackageName());
                        CheckBox chb = (CheckBox) findViewById(resID);
                        if (chb.isChecked()) ans += chb.getText().toString() + " ";
                  }

                  t001.setText(ans);
            }
      };
}