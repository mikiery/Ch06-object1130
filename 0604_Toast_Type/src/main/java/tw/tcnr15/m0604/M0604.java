package tw.tcnr15.m0604;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class M0604 extends AppCompatActivity {

    private Button b001;
    private Button b002;
    private Button b003;
    private Button b004;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0604);
        setupViewComponent();
    }

    private void setupViewComponent() {

        b001 = (Button) findViewById(R.id.m0604_b001);
        b002 = (Button) findViewById(R.id.m0604_b002);
        b003 = (Button) findViewById(R.id.m0604_b003);
        b004 = (Button) findViewById(R.id.m0604_b004);
        b001.setOnClickListener(b001on);
        b002.setOnClickListener(b001on);
        b003.setOnClickListener(b001on);
        b004.setOnClickListener(b001on);

    }

    private View.OnClickListener b001on = new View.OnClickListener() {


        @Override
        public void onClick(View v) {
toast=null;
            switch (v.getId()) {

                case R.id.m0604_b001:
                    Toast.makeText(getApplicationContext(), getText(R.string.m0604_t001), Toast.LENGTH_LONG).show();
                    break;

                case R.id.m0604_b002:
                    //toast = Toast.makeText(getApplicationContext(), getText(R.string.m0604_t002), Toast.LENGTH_LONG);
                  //  toast.setGravity(Gravity.TOP , 0, 0);
                    //toast.show();
                    toast = Toast.makeText(getApplicationContext(), getString(R.string.m0604_t002), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.START | Gravity.TOP, 20, 40);
                    toast.show();

                    break;

                case R.id.m0604_b003:
                    toast = Toast.makeText(getApplicationContext(), getText(R.string.m0604_t003), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP , 0, 0);

                    //LinearLayout oastView = (LinearLayout) toast.getView();
                   // ImageView imageCodeProject = new ImageView(getApplicationContext());
                    ///imageCodeProject.setImageResource(R.drawable.ic_sample);
                //    toastView.addView(imageCodeProject, 0);

//                    LinearLayout oastView=(LinearLayout) toast.getView();
                    ImageView imageCodeProject=new ImageView(getApplicationContext());
                    imageCodeProject.setImageResource(R.drawable.net);
                        toast.setView(imageCodeProject);
                        toast.show();
                        break;

               case R.id.m0604_b004:
                LayoutInflater inflater = getLayoutInflater();
                  View layout = inflater.inflate(R.layout.m0604_a, (ViewGroup) findViewById(R.id.llToast));

                   ImageView image = (ImageView) layout.findViewById(R.id.tvImageToast);
                   TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
                   TextView text = (TextView) layout.findViewById(R.id.tvTextToast);

                image.setImageResource(R.drawable.net);
                  title.setText(getString(R.string.m0604_t001).toString());
                    text.setText(getString(R.string.m0604_test).toString());
//-----------------------------------

//-----------------------------------
                    toast = new Toast(getApplicationContext());
                  toast.setGravity(Gravity.CENTER | Gravity.TOP, 20, 40);
                  toast.setDuration(Toast.LENGTH_LONG);
                 toast.setView(layout);
                toast.show();


            }







        }
    };


}