package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class All_Home_Work extends AppCompatActivity {
    LinearLayout layout_UserInput, lo_ProfitCalculat, lo_ParsentigCalculat, lo_BmiCalculator,
            lo_TempCalculator, ll_Condition, ll_Condition2, ll_HomeWork_214_1, ll_HomeWork_214_2,
            ll_HomeWork_214_3, ll_HomeWork_214_4, ll_HomeWork_214_5, ll_HomeWork_219, ll_HomeWork_223,
            ll_HomeWork_224, ll_HomeWork_225, ll_HomeWork_Test, ll_HomeWork_229, ll_HomeWork_229_1, ll_HomeWork_229_3,
            ll_HomeWork_230, ll_HomeWork_230_1, ll_HomeWork_232_1, ll_HomeWork_232_2, ll_HomeWork_232_3,
            ll_HomeWork_232_4, ll_HomeWork_232_5, ll_HomeWork_233, ll_HomeWork_234, ll_HomeWork_235, ll_HomeWork_236,
            ll_HomeWork_237, ll_HomeWork_253, ll_HomeWork_254, ll_HomeWork_267,ll_HomeWork_268,ll_HomeWork_271,ll_HomeWork_286,
    ll_HomeWork_289;/* ll_HomeWork_253, ll_HomeWork_254, ll_HomeWork_267,ll_HomeWork_268,ll_HomeWork_271,;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_homework);

        layout_UserInput = findViewById(R.id.layout_UserInput);
        lo_ProfitCalculat = findViewById(R.id.lo_ProfitCalculat);
        lo_ParsentigCalculat = findViewById(R.id.lo_ParsentigCalculat);
        lo_TempCalculator = findViewById(R.id.lo_TempCalculator);
        lo_BmiCalculator = findViewById(R.id.lo_BmiCalculator);
        ll_Condition = findViewById(R.id.ll_Condition);
        ll_Condition2 = findViewById(R.id.ll_Condition2);
        ll_HomeWork_214_1 = findViewById(R.id.ll_HomeWork_214_1);
        ll_HomeWork_214_2 = findViewById(R.id.ll_HomeWork_214_2);
        ll_HomeWork_214_3 = findViewById(R.id.ll_HomeWork_214_3);
        ll_HomeWork_214_4 = findViewById(R.id.ll_HomeWork_214_4);
        ll_HomeWork_214_5 = findViewById(R.id.ll_HomeWork_214_5);
        ll_HomeWork_219 = findViewById(R.id.ll_HomeWork_219);
        ll_HomeWork_223 = findViewById(R.id.ll_HomeWork_223);
        ll_HomeWork_224 = findViewById(R.id.ll_HomeWork_224);
        ll_HomeWork_225 = findViewById(R.id.ll_HomeWork_225);
        ll_HomeWork_Test = findViewById(R.id.ll_HomeWork_Test);
        ll_HomeWork_229 = findViewById(R.id.ll_HomeWork_229);
        ll_HomeWork_229_1 = findViewById(R.id.ll_HomeWork_229_1);
        ll_HomeWork_229_3 = findViewById(R.id.ll_HomeWork_229_3);
        ll_HomeWork_230 = findViewById(R.id.ll_HomeWork_230);
        ll_HomeWork_230_1 = findViewById(R.id.ll_HomeWork_230_1);
        ll_HomeWork_232_1 = findViewById(R.id.ll_HomeWork_232_1);
        ll_HomeWork_232_2 = findViewById(R.id.ll_HomeWork_232_2);
        ll_HomeWork_232_3 = findViewById(R.id.ll_HomeWork_232_3);
        ll_HomeWork_232_4 = findViewById(R.id.ll_HomeWork_232_4);
        ll_HomeWork_232_5 = findViewById(R.id.ll_HomeWork_232_5);
        ll_HomeWork_233 = findViewById(R.id.ll_HomeWork_233);
        ll_HomeWork_234 = findViewById(R.id.ll_HomeWork_234);
        ll_HomeWork_235 = findViewById(R.id.ll_HomeWork_235);
        ll_HomeWork_236 = findViewById(R.id.ll_HomeWork_236);
        ll_HomeWork_237 = findViewById(R.id.ll_HomeWork_237);
        ll_HomeWork_253 = findViewById(R.id.ll_HomeWork_253);
        ll_HomeWork_254 = findViewById(R.id.ll_HomeWork_254);
        ll_HomeWork_267 = findViewById(R.id.ll_HomeWork_267);
        ll_HomeWork_268 = findViewById(R.id.ll_HomeWork_268);
        ll_HomeWork_271 = findViewById(R.id.ll_HomeWork_271);
     ll_HomeWork_286 = findViewById(R.id.ll_HomeWork_286);
        ll_HomeWork_289 = findViewById(R.id.ll_HomeWork_289);
      /*  ll_HomeWork_253 = findViewById(R.id.ll_HomeWork_253);
        ll_HomeWork_253 = findViewById(R.id.ll_HomeWork_253);*/

        layout_UserInput.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork203.class);
            startActivity(myIntent);
        });

        lo_ProfitCalculat.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork204.class);
            startActivity(myIntent);
        });
        lo_ParsentigCalculat.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork204_1.class);
            startActivity(myIntent);
        });

        lo_BmiCalculator.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork207.class);
            startActivity(myIntent);
        });

        lo_TempCalculator.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork207_1.class);
            startActivity(myIntent);
        });
        ll_Condition.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork210.class);
            startActivity(myIntent);
        });
        ll_Condition2.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork210_1.class);
            startActivity(myIntent);
        });
        ll_HomeWork_214_1.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork214_1.class);
            startActivity(myIntent);
        });
        ll_HomeWork_214_2.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork214_2.class);
            startActivity(myIntent);
        });
        ll_HomeWork_214_3.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork214_3.class);
            startActivity(myIntent);
        });
        ll_HomeWork_214_4.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork214_4.class);
            startActivity(myIntent);
        });
        ll_HomeWork_214_5.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork214_5.class);
            startActivity(myIntent);
        });
        ll_HomeWork_219.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork219.class);
            startActivity(myIntent);
        });
        ll_HomeWork_223.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork223.class);
            startActivity(myIntent);
        });
        ll_HomeWork_224.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork224.class);
            startActivity(myIntent);
        });
        ll_HomeWork_225.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, PDF_Dashboard.class);
            startActivity(myIntent);
        });
        ll_HomeWork_Test.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, AAA_Test.class);
            startActivity(myIntent);
        });
        ll_HomeWork_229.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork229.class);
            startActivity(myIntent);
        });
        ll_HomeWork_229_1.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork229_1.class);
            startActivity(myIntent);
        });
        ll_HomeWork_229_3.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork229_2.class);
            startActivity(myIntent);
        });
        ll_HomeWork_230.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork232_1.class);
            startActivity(myIntent);
        });
        ll_HomeWork_230_1.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork230_1.class);
            startActivity(myIntent);
        });
        ll_HomeWork_232_1.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork232_1.class);
            startActivity(myIntent);
        });
        ll_HomeWork_232_2.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork232_2.class);
            startActivity(myIntent);
        });
        ll_HomeWork_232_3.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork232_3.class);
            startActivity(myIntent);
        });
        ll_HomeWork_232_4.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork232_4.class);
            startActivity(myIntent);
        });
        ll_HomeWork_232_5.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork232_5.class);
            startActivity(myIntent);
        });
        ll_HomeWork_233.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork233.class);
            startActivity(myIntent);
        });
        ll_HomeWork_234.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork234.class);
            startActivity(myIntent);
        });
        ll_HomeWork_235.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork235.class);
            startActivity(myIntent);
        });
        ll_HomeWork_236.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork236.class);
            startActivity(myIntent);
        });
        ll_HomeWork_237.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork236.class);
            startActivity(myIntent);
        });
        ll_HomeWork_253.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork253.class);
            startActivity(myIntent);
        });
        ll_HomeWork_254.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork254.class);
            startActivity(myIntent);
        });
        ll_HomeWork_267.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork267.class);
            startActivity(myIntent);
        });
        ll_HomeWork_268.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork268.class);
            startActivity(myIntent);
        });
        ll_HomeWork_271.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork271.class);
            startActivity(myIntent);
        });
        ll_HomeWork_286.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork286.class);
            startActivity(myIntent);
        });
        ll_HomeWork_289.setOnClickListener(v -> {
            Intent myIntent = new Intent(All_Home_Work.this, HomeWork289.class);
            startActivity(myIntent);
        });


    }
}