package tw.tcnr05.m0608;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class M0608 extends AppCompatActivity {

    private Button b000;
    private Button b001;
    private Button b002;
    private Button b003;
    private Button b004;
    private Button b005;
    private Button b006;
    private Button b007;
    private Button b008;
    private Button b009;
    private Button b010;
    private Button b012;
    private Button b013;
    private Button b014;
    private Button b015;
    private Button b011;

    private TextView ans;
    private double nn;
    private EditText num1;
    private String s;//用來判斷+-
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0608);
        setupViewwComponent();


    }

    private void setupViewwComponent() {
        b000 = (Button) findViewById(R.id.m0608_b000);
        b001 = (Button) findViewById(R.id.m0608_b001);
        b002 = (Button) findViewById(R.id.m0608_b002);
        b003 = (Button) findViewById(R.id.m0608_b003);
        b004 = (Button) findViewById(R.id.m0608_b004);
        b005 = (Button) findViewById(R.id.m0608_b005);
        b006 = (Button) findViewById(R.id.m0608_b006);
        b007 = (Button) findViewById(R.id.m0608_b007);
        b008 = (Button) findViewById(R.id.m0608_b008);
        b009 = (Button) findViewById(R.id.m0608_b009);
        b010 = (Button) findViewById(R.id.m0608_b010);
        b012 = (Button) findViewById(R.id.m0608_b012);
        b013 = (Button) findViewById(R.id.m0608_b013);
        b014 = (Button) findViewById(R.id.m0608_b014);
        b015 = (Button) findViewById(R.id.m0608_b015);
        b011 = (Button) findViewById(R.id.m0608_b011);


        b000.setOnClickListener(B001ON);
        b001.setOnClickListener(B001ON);
        b002.setOnClickListener(B001ON);
        b003.setOnClickListener(B001ON);
        b004.setOnClickListener(B001ON);
        b005.setOnClickListener(B001ON);
        b006.setOnClickListener(B001ON);
        b007.setOnClickListener(B001ON);
        b008.setOnClickListener(B001ON);
        b009.setOnClickListener(B001ON);
        b010.setOnClickListener(B001ON);


        b011.setOnClickListener(B002ON);
        b012.setOnClickListener(B002ON);
        b013.setOnClickListener(B002ON);
        b014.setOnClickListener(B002ON);

        b015.setOnClickListener(B003ON);
        num1 = (EditText) findViewById(R.id.m0608_e001);
        num1.setText("");
        ans = (TextView) findViewById(R.id.m0608_t001);

    }

    private View.OnClickListener B001ON = new View.OnClickListener() {


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

    private View.OnClickListener B002ON = new View.OnClickListener() {




        @Override
        public void onClick(View v) {


            try {
                nn = Double.parseDouble(num1.getText().toString());


            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), getText(R.string.error), Toast.LENGTH_LONG).show();


            }
            num1.setText("");
            switch (v.getId()) {
                case R.id.m0608_b011:
                    s = "P";

                    break;

                case R.id.m0608_b012:
                    s = "M";

                    break;

                case R.id.m0608_b013:
                    s = "X";

                    break;

                case R.id.m0608_b014:
                    s = "D";


                    break;


            }
        }
    };


    private View.OnClickListener B003ON = new View.OnClickListener() {


        @Override
        public void onClick(View v) {


            if (num1.getText().toString().trim().length() != 0) {
                double n2 = Double.parseDouble(num1.getText().toString());

                DecimalFormat nf = new DecimalFormat("0.0000");

                if (s.equals("P")) ans.setText(nf.format(nn + n2));
                if (s.equals("M")) ans.setText(nf.format(nn - n2));
                if (s.equals("X")) ans.setText(nf.format(nn * n2));
                if (s.equals("D")) ans.setText(nf.format(nn / n2));

                num1.setText("");
                nn = 0;

            } else {
                Toast.makeText(getApplicationContext(), getText(R.string.m0608_error), Toast.LENGTH_LONG).show();

            }


        }


    };


}