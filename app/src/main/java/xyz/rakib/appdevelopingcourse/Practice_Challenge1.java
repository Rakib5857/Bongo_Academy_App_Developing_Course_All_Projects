package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class Practice_Challenge1 extends AppCompatActivity implements View.OnClickListener  {

    TextView solution_tv,result_tv;
    MaterialButton button_C,button_open_bracket,button_close,button_divider,
            button_7,button_8,button_9,button_intu,button_4,button_5,
            button_6,button_plush,button_1,button_2,button_3,button_mainas,
            button_ac,button_0,button_dot,button_equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_challenge1);

        solution_tv = findViewById(R.id.solution_tv);
        result_tv = findViewById(R.id.result_tv);


        assignId(button_C,R.id.button_C);
        assignId(button_open_bracket,R.id.button_open_bracket);
        assignId(button_close,R.id.button_close);
        assignId(button_0,R.id.button_0);
        assignId( button_9,R.id.button_9);
        assignId(button_8,R.id.button_8);
        assignId(button_7,R.id.button_7);
        assignId(button_6,R.id.button_6);
        assignId(button_5,R.id.button_5);
        assignId(button_4,R.id.button_4);
        assignId(button_3,R.id.button_3);
        assignId(button_2,R.id.button_2);
        assignId( button_1,R.id.button_1);
        assignId( button_ac,R.id.button_ac);
        assignId(button_equal,R.id.button_equal);
        assignId(button_divider,R.id.button_divider);
        assignId(button_intu,R.id.button_intu);
        assignId(button_plush,R.id.button_plush);
        assignId(button_mainas,R.id.button_mainas);
        assignId(button_dot,R.id.button_dot);

    }
    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener((View.OnClickListener) this);
    }


    @Override
    public void onClick(View v) {
        MaterialButton button =(MaterialButton) v;
        String buttonText = button.getText().toString();
        String dataToCalculate = solution_tv.getText().toString();
        if (buttonText.equals("AC")){
            solution_tv.setText("0");
            result_tv.setText("0");
            return;
        }
        if (buttonText.equals("=")){
            solution_tv.setText(result_tv.getText());
            return;
        }
        if (buttonText.equals("C")) {
            dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
        }else {
            dataToCalculate = dataToCalculate+buttonText;
        }
        solution_tv.setText(dataToCalculate);
    }
    String getResult(String data){

        return "Calculated";
    }
}