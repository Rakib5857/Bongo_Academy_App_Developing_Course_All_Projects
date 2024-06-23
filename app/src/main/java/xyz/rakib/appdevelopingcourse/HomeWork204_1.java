package xyz.rakib.appdevelopingcourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeWork204_1 extends AppCompatActivity {

    EditText ed_Buy,ed_Parcent;
    Button  b_ClickHere;
    TextView tv_Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work204_1);

        ed_Buy = findViewById(R.id.ed_Buy);
        ed_Parcent = findViewById(R.id.ed_Parcent);
        b_ClickHere = findViewById(R.id.b_ClickHere);
        tv_Display = findViewById(R.id.tv_Display);


        b_ClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float buyPrice, sellPrice, profitPercent;


                try {
                    buyPrice = Float.parseFloat(ed_Buy.getText().toString());
                    profitPercent = Float.parseFloat(ed_Parcent.getText().toString());

                    sellPrice = buyPrice * (1 + profitPercent / 100); // calculate the selling price correctly
                    if (sellPrice == buyPrice) { // check if the selling price is equal to the buy price
                        Toast.makeText(HomeWork204_1.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                    } else {
                        tv_Display.setText("Your Selling Price : " + sellPrice);
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(HomeWork204_1.this, "কেনা দাম আর % লিখুন", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}