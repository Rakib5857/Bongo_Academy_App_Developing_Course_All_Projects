package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeWork234 extends AppCompatActivity {

    EditText ed_InputValue;
    Button b_ClickHere;
    TextView tv_Display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work234);

        ed_InputValue = findViewById(R.id.ed_InputValue);
        b_ClickHere = findViewById(R.id.b_ClickHere);

        tv_Display = findViewById(R.id.tv_Display);

        b_ClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = ed_InputValue.getText().toString();

                if (s.isEmpty()){
                    ed_InputValue.setError("Input your value");
                    tv_Display.setText("");
                } else {
                    tv_Display.setText("");
                    int value = Integer.parseInt(s);
                    boolean isPrime = true;

                    if (value <= 1) {
                        isPrime = false;
                    } else {
                        for (int x = 2; x < value; x++) {
                            if (value % x == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }

                    if (isPrime) {
                        tv_Display.setText(value + " Is a Prime Number");
                    } else {
                        tv_Display.setText(value + " Is Not a Prime Number");
                    }
                }
            }
        });

    }
}