package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

public class HomeWork225 extends AppCompatActivity {


    public static String myString ="";

    PDFView pdfView;
    LottieAnimationView lv_Loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work225);
        pdfView = findViewById(R.id.pdfView);
        lv_Loading = findViewById(R.id.lv_Loading);


        pdfView.setVisibility(View.INVISIBLE);
        lv_Loading.setVisibility(View.VISIBLE);


        pdfView.fromAsset(myString)
                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {
                        pdfView.setVisibility(View.VISIBLE);
                        lv_Loading.setVisibility(View.GONE);
                        Toast.makeText(HomeWork225.this, "Loaded", Toast.LENGTH_SHORT).show();
                    }
                })
                .load();


    }
}