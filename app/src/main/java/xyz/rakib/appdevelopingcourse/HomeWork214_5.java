package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeWork214_5 extends AppCompatActivity {

    EditText ed_Units;
    Button b_ClickHere;
    TextView tv_Display,tv_Display2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work214_5);

        ed_Units = findViewById(R.id.ed_Units);
        b_ClickHere = findViewById(R.id.b_ClickHere);
        tv_Display = findViewById(R.id.tv_Display);
        tv_Display2 = findViewById(R.id.tv_Display2);

        b_ClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Parse units from EditText field
                    int unit = Integer.parseInt(ed_Units.getText().toString());

                    float amt, total_amt, sur_charge;

                    if(unit <= 50)
                    {
                        amt = (float) (unit * 0.50);
                    }
                    else if(unit <= 150)
                    {
                        amt = (float) (25 + ((unit-50) * 0.75));
                    }
                    else if(unit <= 250)
                    {
                        amt = (float) (100 + ((unit-150) * 1.20));
                    }
                    else
                    {
                        amt = (float) (220 + ((unit-250) * 1.50));
                    }

                    // Calculate surcharge (20% of the calculated amount)
                    sur_charge = amt * 0.20f;

                    // Calculate total amount including surcharge
                    total_amt = amt + sur_charge;

                    // Display electricity bill
                    tv_Display.setText("Your Electricity Bill BDT : " + total_amt);
                } catch (NumberFormatException e) {
                    // Handle the case where the input is not a valid integer
                    Toast.makeText(HomeWork214_5.this, "Please enter valid units", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
