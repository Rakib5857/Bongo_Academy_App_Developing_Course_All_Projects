package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.DayOfWeek;

public class HomeWork214_3 extends AppCompatActivity {

    EditText ed_InputNumber;
    Button b_ClickHere;
    TextView tv_Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work214_3);

        ed_InputNumber = findViewById(R.id.ed_InputNumber);
        b_ClickHere = findViewById(R.id.b_ClickHere);
        tv_Display = findViewById(R.id.tv_Display);

        b_ClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String myString = ed_InputNumber.getText().toString();
                if (myString.length()>0) {

                    int daynumber = Integer.parseInt(myString);


                    if (daynumber == 1){
                        tv_Display.setText("Monday");
                    } else if (daynumber == 2){
                        tv_Display.setText("Tuesday");
                    } else if (daynumber == 3){
                        tv_Display.setText("Wednesday");

                    } else if (daynumber == 4){
                        tv_Display.setText("Thursday");

                    } else if (daynumber == 5){
                        tv_Display.setText("Friday");

                    } else if (daynumber == 6){
                        tv_Display.setText("Saturday");

                    } else if (daynumber == 7){
                        tv_Display.setText("Sunday");

                    }else {
                        tv_Display.setText("");
                        ed_InputNumber.setText("");
                        Toast.makeText(HomeWork214_3.this,"Enter a day number between 1 to 7",Toast.LENGTH_LONG).show();

                    }


                }else {
                    ed_InputNumber.setError("Please Input Your Number");
                }

            }
        });

    }
}