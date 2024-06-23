package xyz.rakib.appdevelopingcourse;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class HomeWork223 extends AppCompatActivity {


    Button button1,button2;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work223);

        Button button1 =findViewById(R.id.button1);
        Button button2 =findViewById(R.id.button2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer!=null) mediaPlayer.release();


                mediaPlayer = MediaPlayer.create(HomeWork223.this,R.raw.song);
                mediaPlayer.start();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mediaPlayer!=null) mediaPlayer.release();

                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource("https://www.learningcontainer.com/wp-content/uploads/2020/02/Kalimba.mp3");
                    mediaPlayer.prepare();
                    mediaPlayer.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}