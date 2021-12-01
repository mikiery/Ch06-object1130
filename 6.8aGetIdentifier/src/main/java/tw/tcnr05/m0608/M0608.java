package tw.tcnr05.m0608;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class M0608 extends AppCompatActivity {

    private TextView num1;
    private double n1 = 0;
    private String s = "S"; //用來判斷+-*/
    private DecimalFormat nf;
    private TextView show;
    private double nn;
    private double n2 = 0;
    private String se = "";
    private String st = "";
    private Boolean e_ok = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0608);
        setupViewComponent();
    }

    private void setupViewComponent() {
        num1 = (TextView) findViewById(R.id.m0608_e001);
        show = (TextView) findViewById(R.id.m0608_show);

//        clearOnClick.onClick(null);

        nf = new DecimalFormat("0.0000");
        //-----巨集執行----
        for (int i = 0; i < 18; i++) {
            String idName = "m0608_b0" + String.format("%02d", i);
            int resID = getResources().getIdentifier(idName, "id", getPackageName());

            Button btn = ((Button) findViewById(resID));
            if (i < 11) btn.setOnClickListener(numberOnClick);
            if (i > 10 && i < 15) btn.setOnClickListener(calOnClick);
            if (i == 15) btn.setOnClickListener(equalOnClick);
            if (i == 16) btn.setOnClickListener(delOnClick);
            if (i == 17) btn.setOnClickListener(clearOnClick);
        }
        num1.setText("");
        show.setText("");
    }


    private Button.OnClickListener numberOnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            String keyin = num1.getText().toString();
            switch (v.getId()) {
                case R.id.m0608_b000:
                    num1.setText(keyin + "0");
                    break;
                case R.id.m0608_b001:
                    num1.setText(keyin + "1");
                    break;
                case R.id.m0608_b002:
                    num1.setText(keyin + "2");
                    break;
                case R.id.m0608_b003:
                    num1.setText(keyin + "3");
                    break;
                case R.id.m0608_b004:
                    num1.setText(keyin + "4");
                    break;
                case R.id.m0608_b005:
                    num1.setText(keyin + "5");
                    break;
                case R.id.m0608_b006:
                    num1.setText(keyin + "6");
                    break;
                case R.id.m0608_b007:
                    num1.setText(keyin + "7");
                    break;
                case R.id.m0608_b008:
                    num1.setText(keyin + "8");
                    break;
                case R.id.m0608_b009:
                    num1.setText(keyin + "9");
                    break;
                case R.id.m0608_b010:
                    num1.setText(keyin + ".");
                    break;
            }
        }
    };
    ////-----------修正 1-1-1=-1
    private View.OnClickListener calOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                if (num1.getText().toString().equals("") && v.getId() == R.id.m0608_b012) {
                    num1.setText("-");
                } else {

                    //-----------進行執行中的運算----------//
                    nn = Double.parseDouble(num1.getText().toString());
                    int a = 0;
//                u_Calculation(nn);
                    if (s.equals("S")) n1 = nn;
                    u_Calculation(nn);
                    num1.setText("");
                    switch (v.getId()) {
                        case R.id.m0608_b011:
                            s = "P";
                            show.setText(getString(R.string.m0608_b011));
                            break;
                        case R.id.m0608_b012:
                            s = "M";
                            show.setText(getString(R.string.m0608_b012));
                            break;
                        case R.id.m0608_b013:
                            s = "X";
                            show.setText(getString(R.string.m0608_b013));
                            break;
                        case R.id.m0608_b014:
                            s = "D";
                            show.setText(getString(R.string.m0608_b014));
                            break;
                    }
                }
            } catch (Exception e) {
            }
        }
    };
    //------------------------------------------------------

    private void u_Calculation(double in_nn) {
        if (s.equals("P")) n1 += in_nn; //上一個運算符號
        if (s.equals("M")) n1 -= in_nn;
        if (s.equals("X")) n1 *= in_nn;
        if (s.equals("D")) n1 /= in_nn;
    }

    private View.OnClickListener equalOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (num1.getText().toString().trim().length() != 0) {
                n2 = Double.parseDouble(num1.getText().toString());
                DecimalFormat nf = new DecimalFormat("0.0000");
                u_Calculation(n2);
                num1.setText(nf.format(n1));
                show.setText(getString(R.string.m0608_b015));
                n1 = 0;
                nn = 0;
            }
        }
    };


    //-----------------------可連續計算-------------------
//private View.OnClickListener equalOnClick = new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
////            Toast.makeText(getApplicationContext(), Double.toString(n1), Toast.LENGTH_LONG).show();
//        if (num1.getText().toString().trim().length() != 0) {
//            if (!se.equals("1")){
//                n2 = Double.parseDouble((num1.getText().toString()));
//
//            } else{
//                s=st;
//
//            }
//
//            nf = new DecimalFormat("0.0000");
//            u_Calculation(n2);
//            num1.setText(nf.format(n1));
////                if (s.equals("")) num1.setText(nf.format(n2));
////                num1.setText("");
//            //n1 = 0;
//            se = "1";
//            st=s;
//            s="E";
//            show.setText(getString(R.string.m0608_b015));
////                num1.setText(ans.getText());
////                num1.setText("");
////                n1 = 0;
//        }
//    }
//};
    //----------------------------------------

    private View.OnClickListener delOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            num1.setText("");
        }
    };
    private Button.OnClickListener clearOnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            n1 = 0;
            num1.setText("");
            show.setText("");
            if (!s.equals("E")) {  //按= 狀態 不清除結果欄
                num1.setText("");
                show.setText("");
            }
            s = "S";  //設成起始狀態
        }
    };
    //------------------end---------------
}
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.text.DecimalFormat;
//
//public class M0608 extends AppCompatActivity {
//
//    private TextView num1;
//    private TextView show;
//    private DecimalFormat nf;
//
//    //    private Button b000;
////    private Button b001;
////    private Button b002;
////    private Button b003;
////    private Button b004;
////    private Button b005;
////    private Button b006;
////    private Button b007;
////    private Button b008;
////    private Button b009;
////    private Button b010;
////    private Button b012;
////    private Button b013;
////    private Button b014;
////    private Button b015;
////    private Button b011;
////
//// private TextView ans;
////  private double nn;
////private EditText num1;
////private String s;//用來判斷+-
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.m0608);
//        setupViewwComponent();
//
//
//
//
//    }
//
//    private void setupViewwComponent() {
//
//
//    num1=(TextView)findViewById(R.id.m0608_e001);
//    show=(TextView)findViewById(R.id.m0608_show);
//        nf=new DecimalFormat("0.0000");
//
//
//        for (int i=0;i<18;i++){
//            String idName = "m0608_b0" + String.format("%02d,i");    //缺位數補0
//            int resID = getResources().getIdentifier(idName, "id", getPackageName());
//            Button btn = (Button) findViewById(resID);
//            if (i<11) btn.setOnClickListener(numberOnClick);
//            if (i > 10 && i < 15) btn.setOnClickListener(calOnClick);
//            if (i == 15) btn.setOnClickListener(equalOnClick);
//            if (i == 16) btn.setOnClickListener(delOnClick);
//            if (i == 17) btn.setOnClickListener(clearOnClick);
//        }
//num1.setText("");
//show.setText("");
//        }
//        private View.OnClickListener numberOnClick=new View.OnClickListener(){
//
//
//
//    }
//
//
//
//
////    private void setupViewwComponent() {
////        b000 = (Button) findViewById(R.id.m0608_b000);
////        b001 = (Button) findViewById(R.id.m0608_b001);
////        b002 = (Button) findViewById(R.id.m0608_b002);
////        b003 = (Button) findViewById(R.id.m0608_b003);
////        b004 = (Button) findViewById(R.id.m0608_b004);
////        b005 = (Button) findViewById(R.id.m0608_b005);
////        b006 = (Button) findViewById(R.id.m0608_b006);
////        b007 = (Button) findViewById(R.id.m0608_b007);
////        b008 = (Button) findViewById(R.id.m0608_b008);
////        b009 = (Button) findViewById(R.id.m0608_b009);
////        b010 = (Button) findViewById(R.id.m0608_b010);
////        b012 = (Button) findViewById(R.id.m0608_b012);
////        b013 = (Button) findViewById(R.id.m0608_b013);
////        b014 = (Button) findViewById(R.id.m0608_b014);
////        b015 = (Button) findViewById(R.id.m0608_b015);
////        b011 = (Button) findViewById(R.id.m0608_b011);
////
////
////        b000.setOnClickListener(B001ON);
////        b001.setOnClickListener(B001ON);
////        b002.setOnClickListener(B001ON);
////        b003.setOnClickListener(B001ON);
////        b004.setOnClickListener(B001ON);
////        b005.setOnClickListener(B001ON);
////        b006.setOnClickListener(B001ON);
////        b007.setOnClickListener(B001ON);
////        b008.setOnClickListener(B001ON);
////        b009.setOnClickListener(B001ON);
////        b010.setOnClickListener(B001ON);
////
////
////        b011.setOnClickListener(B002ON);
////        b012.setOnClickListener(B002ON);
////        b013.setOnClickListener(B002ON);
////        b014.setOnClickListener(B002ON);
////
////        b015.setOnClickListener(B003ON);
////        num1 = (EditText) findViewById(R.id.m0608_e001);
////        num1.setText("");
////        ans = (TextView) findViewById(R.id.m0608_t001);
////
////    }
////
//
////    private View.OnClickListener B001ON = new View.OnClickListener() {
////
////
////        @Override
////        public void onClick(View v) {
////
////            String keyin = num1.getText().toString();
////
////            switch (v.getId()) {
////
////                case R.id.m0608_b000:
////                    num1.setText(keyin + "0");
////                    break;
////                case R.id.m0608_b001:
////                    num1.setText(keyin + "1");
////                    break;
////                case R.id.m0608_b002:
////                    num1.setText(keyin + "2");
////                    break;
////                case R.id.m0608_b003:
////                    num1.setText(keyin + "3");
////                    break;
////                case R.id.m0608_b004:
////                    num1.setText(keyin + "4");
////                    break;
////                case R.id.m0608_b005:
////                    num1.setText(keyin + "5");
////                    break;
////                case R.id.m0608_b006:
////                    num1.setText(keyin + "6");
////                    break;
////                case R.id.m0608_b007:
////                    num1.setText(keyin + "7");
////                    break;
////                case R.id.m0608_b008:
////                    num1.setText(keyin + "8");
////                    break;
////                case R.id.m0608_b009:
////                    num1.setText(keyin + "9");
////                    break;
////
////                case R.id.m0608_b010:
////                    num1.setText(keyin + ".");
////                    break;
////
////
////            }
////
////
////        }
////    };
////
////    private View.OnClickListener B002ON = new View.OnClickListener() {
////
////
////
////
////        @Override
////        public void onClick(View v) {
////
////
////            try {
////                nn = Double.parseDouble(num1.getText().toString());
////
////
////            } catch (Exception e) {
////                Toast.makeText(getApplicationContext(), getText(R.string.error), Toast.LENGTH_LONG).show();
////
////
////            }
////            num1.setText("");
////            switch (v.getId()) {
////                case R.id.m0608_b011:
////                    s = "P";
////
////                    break;
////
////                case R.id.m0608_b012:
////                    s = "M";
////
////                    break;
////
////                case R.id.m0608_b013:
////                    s = "X";
////
////                    break;
////
////                case R.id.m0608_b014:
////                    s = "D";
////
////
////                    break;
////
////
////            }
////        }
////    };
////
////
////    private View.OnClickListener B003ON = new View.OnClickListener() {
////
////
////        @Override
////        public void onClick(View v) {
////
////
////            if (num1.getText().toString().trim().length() != 0) {
////                double n2 = Double.parseDouble(num1.getText().toString());
////
////                DecimalFormat nf = new DecimalFormat("0.0000");
////
////                if (s.equals("P")) ans.setText(nf.format(nn + n2));
////                if (s.equals("M")) ans.setText(nf.format(nn - n2));
////                if (s.equals("X")) ans.setText(nf.format(nn * n2));
////                if (s.equals("D")) ans.setText(nf.format(nn / n2));
////
////                num1.setText("");
////                nn = 0;
////
////            } else {
////                Toast.makeText(getApplicationContext(), getText(R.string.m0608_error), Toast.LENGTH_LONG).show();
////
////            }
////
////
////        }
////
////
//    };


