package xyz.rakib.appdevelopingcourse;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeWork203 extends AppCompatActivity {

    TextView text_Display;
    EditText editText_Input;
    Button button_ClickHere;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work203);

        text_Display = findViewById(R.id.text_Display);
        editText_Input = findViewById(R.id.editText_Input);
        button_ClickHere = findViewById(R.id.button_ClickHere);

        button_ClickHere.setOnClickListener(v -> {
           String userName = editText_Input.getText().toString();
          if (userName.isEmpty()){
              editText_Input.setError("আপনার নাম লিখুন");
                 }else {
              text_Display.setText("হ্যালো, " + userName + "\nGreat Work!!");
          }});

    }
}