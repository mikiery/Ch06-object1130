package tw.tcnr05.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0503 extends AppCompatActivity {

    private Button b001;
    private CheckBox chb01;
    private CheckBox chb02;
    private CheckBox chb03;
    private CheckBox chb04;
    private TextView t001;
    private String dd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0503);

        setViewcomponent();
    }

    //

     private void  setViewcomponent(){

        Intent intent=this.getIntent();
        dd=intent.getStringExtra("cc");
        this.setTitle(dd);




        b001=(Button)findViewById(R.id.m0503_b001);
        chb01=(CheckBox)findViewById(R.id.m0503_chb01);
        chb02=(CheckBox)findViewById(R.id.m0503_chb02);
        chb03=(CheckBox)findViewById(R.id.m0503_chb03);
        chb04=(CheckBox)findViewById(R.id.m0503_chb04);
        t001=(TextView)findViewById(R.id.m0503_t001);
        b001.setOnClickListener(b001on);

    }

    private View.OnClickListener b001on=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String ans=getString(R.string.m0503_t001);

            if (chb01.isChecked())  ans+=chb01.getText().toString()+" ";
            if (chb02.isChecked())  ans+=chb02.getText().toString()+" ";
            if (chb03.isChecked())  ans+=chb03.getText().toString()+" ";
            if (chb04.isChecked())  ans+=chb04.getText().toString()+" ";





            t001.setText(ans);

        }
    };
}