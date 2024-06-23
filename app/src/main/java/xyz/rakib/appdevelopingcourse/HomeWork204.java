package xyz.rakib.appdevelopingcourse;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeWork204 extends AppCompatActivity {

    EditText ed_Buy,ed_Sell;
    Button  ed_ClickHere;
    TextView tv_Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work204);

        ed_Buy = findViewById(R.id.ed_Buy);
        ed_Sell = findViewById(R.id.ed_Sell);
        ed_ClickHere = findViewById(R.id.ed_ClickHere);
        tv_Display = findViewById(R.id.tv_Display);


        ed_ClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float buyPrice = Float.parseFloat(ed_Buy.getText().toString());
                    float sellPrice = Float.parseFloat(ed_Sell.getText().toString());


                    float profit = sellPrice - buyPrice;
                    float profitPercent = (profit / buyPrice) * 100;

                    tv_Display.setText("Profit is: " + profit + "\nProfit % is: " + profitPercent + "%");
                } catch (NumberFormatException e) {
                    Toast.makeText(HomeWork204.this, "বিক্রয় আর কেনা দাম লিখুন", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}