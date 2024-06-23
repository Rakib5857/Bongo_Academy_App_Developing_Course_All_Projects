package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeWork207 extends AppCompatActivity {

    EditText ed_Weight, ed_Height_Fit, ed_Height_Inc;
    Button b_ClickHere;
    TextView tv_Display, tv_Ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work207);

        initializeViews();
        setupTextWatcher();
        setupClickListener();
    }

    private void initializeViews() {
        ed_Weight = findViewById(R.id.ed_Weight);
        ed_Height_Fit = findViewById(R.id.ed_Hight_Fit);
        ed_Height_Inc = findViewById(R.id.ed_Hight_Inc);
        b_ClickHere = findViewById(R.id.b_ClickHere);
        tv_Display = findViewById(R.id.tv_Display);
        tv_Ok = findViewById(R.id.tv_Ok);
    }

    private void setupTextWatcher() {
        ed_Weight.addTextChangedListener(textWatcher);
        ed_Height_Fit.addTextChangedListener(textWatcher);
        ed_Height_Inc.addTextChangedListener(textWatcher);
    }

    private void setupClickListener() {
        b_ClickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            enableButtonClick();
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    private void calculateBMI() {
        try {
            float weight = Float.parseFloat(ed_Weight.getText().toString());
            float heightFit = Float.parseFloat(ed_Height_Fit.getText().toString());
            float heightInc = Float.parseFloat(ed_Height_Inc.getText().toString());

            float myHeight = (float) (heightFit * 0.3048 + heightInc * 0.0254);
            float bmiIndex = weight / (myHeight * myHeight);

            displayBMIResult(bmiIndex);
        } catch (NumberFormatException e) {
            // Handle invalid input
            Toast.makeText(HomeWork207.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
        }
    }

    private void displayBMIResult(float bmiIndex) {
        tv_Display.setText("আপনার BMI : " + bmiIndex);

        if (bmiIndex > 24.9) {
            tv_Ok.setText("আপনি মোটা হয়ে গেছেন \n আরো বেশি পরিশ্রমী হতে হবে, নামাজ-রোজা করতে হবে, বেশি করে পানি আর স্বাস্থ্যসম্মত খাবার খেতে হবে");
            tv_Ok.setTextColor(Color.parseColor("#FF0000"));
        } else if (bmiIndex > 18.9) {
            tv_Ok.setText("আলহামদুলিল্লাহ্‌ আপনার BMI ঠিক আছে ");
            tv_Ok.setTextColor(Color.parseColor("#4B0082"));
        } else {
            tv_Ok.setText("আপনি শুকিয়ে যাচ্ছেন \n ঠিক মতো খাওয়া-দাওয়া করুন ");
            tv_Ok.setTextColor(Color.parseColor("#FFFAFA"));
        }
    }

    private void enableButtonClick() {
        String edWeight = ed_Weight.getText().toString().trim();
        String edFit = ed_Height_Fit.getText().toString().trim();
        String edInc = ed_Height_Inc.getText().toString().trim();

        b_ClickHere.setEnabled(!edWeight.isEmpty() && !edFit.isEmpty() && !edInc.isEmpty());
    }
}
