package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeWork214_2 extends AppCompatActivity {

    EditText ed_InputNumber;
    Button b_ClickHere;
    TextView tv_Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work214_2);

        ed_InputNumber = findViewById(R.id.ed_InputNumber);
        b_ClickHere = findViewById(R.id.b_ClickHere);
        tv_Display = findViewById(R.id.tv_Display);


        b_ClickHere.setOnClickListener(v -> {


            String myString = ed_InputNumber.getText().toString();

            if (myString.length()>0) {
                int year = Integer.parseInt(myString);


                if ((year % 4 == 0) || (year % 400 == 0) || (year % 100 == 0)) {
                    tv_Display.setTextColor(Color.parseColor("#ADFF2F"));
                    tv_Display.setText("It is leap year");

                } else {
                    tv_Display.setTextColor(Color.parseColor("#8B0000"));
                    tv_Display.setText("It is Not leap year");
                }
            }else {
                ed_InputNumber.setError("Please Input Your Number");
            }

        });


    }
}