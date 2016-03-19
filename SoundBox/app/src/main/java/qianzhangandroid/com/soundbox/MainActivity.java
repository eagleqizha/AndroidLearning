package qianzhangandroid.com.soundbox;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView show;
    private Button prev;
    private Button play;
    private Button next;
    private MediaPlayer media;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        media = new MediaPlayer();
        media = MediaPlayer.create(getApplicationContext(), R.raw.game_field);
        show = (TextView) findViewById(R.id.artistName);
        play = (Button) findViewById(R.id.playButton);
        prev = (Button) findViewById(R.id.prevButton);
        next = (Button) findViewById(R.id.nextButton);
        play.setOnClickListener(this);
        prev.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.playButton:
                if(media.isPlaying()){
                    pause();
                }else{
                    play();
                }
                break;
            case R.id.prevButton:

                pause();
                prev();
                break;
            case R.id.nextButton:

                pause();
                next();
                break;
        }
    }
    public void play(){
        if(media != null){
            media.start();
            show.setText("Music playing now...");
            play.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));
        }
    }
    public void pause(){
        if(media != null){
            media.pause();
            show.setText("Music paused now...");
            play.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));
        }
    }
    public void prev(){
        if(media != null){
            media.pause();
            show.setText("No previous media");
        }
    }
    public void next(){
        if(media != null){
            media.pause();
            show.setText("No next media");
        }
    }

    @Override
    protected void onDestroy() {
        if(media != null){
            media.stop();
            media.release();
            media = null;
        }
        super.onDestroy();
    }
}
