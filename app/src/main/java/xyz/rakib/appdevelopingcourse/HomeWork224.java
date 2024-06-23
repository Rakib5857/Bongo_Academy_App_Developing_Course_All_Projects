package xyz.rakib.appdevelopingcourse;

import static xyz.rakib.appdevelopingcourse.R.drawable.ic_pause;
import static xyz.rakib.appdevelopingcourse.R.drawable.ic_play;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.chibde.visualizer.SquareBarVisualizer;

public class HomeWork224 extends AppCompatActivity {
    Button next,prev,replay,forward;
    TextView textSong,textStart,textEnd;
    SeekBar seekMusicBar;

    SquareBarVisualizer squareBarVisualizer;

    ImageView imageView,play;
     MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work224);

        play=findViewById(R.id.playBtn);
        next=findViewById(R.id.nextBtn);
        prev=findViewById(R.id.prevBtn);
        replay=findViewById(R.id.replayBtn);
        forward=findViewById(R.id.forBtn);
        textSong=findViewById(R.id.textSong);
        textStart=findViewById(R.id.txtSongStart);
        textEnd=findViewById(R.id.txtSongEnd);
        seekMusicBar=findViewById(R.id.seekBar);
        squareBarVisualizer = findViewById(R.id.visualizer);
        imageView=findViewById(R.id.img);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (play.getTag() != null && play.getTag().toString().contains("pause")) {




                    mediaPlayer = MediaPlayer.create(HomeWork224.this, R.raw.song);
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.ic_pause);
                    play.setTag("playing");

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            play.setImageResource(ic_play);
                            play.setTag("pause");
                        }
                    });

                } else {
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_play);
                    play.setTag("pause");

                }
            }
        });



    }
}