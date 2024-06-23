package xyz.rakib.appdevelopingcourse;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class HomeWork207_1  extends AppCompatActivity {

    private EditText editTextCelsius, editTextFahrenheit;
    public ImageView buttonSwap;
    public TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work207_1);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        buttonSwap = findViewById(R.id.buttonSwap);
        textViewResult = findViewById(R.id.textViewResult);

       // editTextCelsius.addTextChangedListener(celsiusWatcher);
        editTextFahrenheit.addTextChangedListener(fahrenheitWatcher);

        buttonSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusStr = editTextCelsius.getText().toString();
                String fahrenheitStr = editTextFahrenheit.getText().toString();

                editTextCelsius.setText(fahrenheitStr);
                editTextFahrenheit.setText(celsiusStr);
            }
        });
    }

/*   private final TextWatcher celsiusWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!s.toString().isEmpty()) {
                double celsius = Double.parseDouble(s.toString());
                double fahrenheit = celsiusToFahrenheit(celsius);
                editTextFahrenheit.setText(String.valueOf(fahrenheit));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };*/

    private final TextWatcher fahrenheitWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!s.toString().isEmpty()) {
                double fahrenheit = Double.parseDouble(s.toString());
                double celsius = fahrenheitToCelsius(fahrenheit);
                editTextCelsius.setText(String.valueOf(celsius));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };

    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}