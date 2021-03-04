package com.example.oceanedu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

// https://www.geeksforgeeks.org/image-slider-in-android-using-viewpager/

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPage;
    Button buttonAudio;

    MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.sound_file_1);


    String s1[], s2[];
    int images [] = {R.drawable.dolphin, R.drawable.seahorse, R.drawable.seaturtle,
            R.drawable.shark, R.drawable.octopus, R.drawable.jellyfish, R.drawable.lobster,
            R.drawable.starfish, R.drawable.orca, R.drawable.mantaray};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the ImagePageAdapter similar to other RecycleView Adapters
        viewPage = (ViewPager2) findViewById(R.id.viewPagerMain);
        OceanAdapter adapter = new OceanAdapter(this, s1, s2, images);
        viewPage.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        s1 = getResources().getStringArray(R.array.Animal_Names);
        s2 = getResources().getStringArray(R.array.description);

//        recyclerView.setAdapter(oceanAdapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //For audio or video of animal in action??
    private void setupButtonWeb1() {
        buttonAudio = findViewById(R.id.buttonAudio);
        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add implicit intent code to open web browser to event 1
                //When the web info button is clicked open a web browser
                Uri webpage = Uri.parse("audio.com"); //or watch me(animal) in action??
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                //Verify there is an app that can handle the intent
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });
    }

    //Or set audio to the button and create another array
    private void setButtonAudio(){
        String url = "http://........"; // your URL here
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );
        mediaPlayer.setDataSource(url);
        mediaPlayer.prepare(); // might take long! (for buffering, etc)
        mediaPlayer.start();
    }

    //Or this??
    public class MyService extends Service implements MediaPlayer.OnPreparedListener {
        private static final String ACTION_PLAY = "com.example.action.PLAY";
        MediaPlayer mediaPlayer = null;

        public int onStartCommand(Intent intent, int flags, int startId) {
        ...
            if (intent.getAction().equals(ACTION_PLAY)) {
                mediaPlayer = ... // initialize it here
                mediaPlayer.setOnPreparedListener(this);
                mediaPlayer.prepareAsync(); // prepare async to not block main thread
            }
        }

        /** Called when MediaPlayer is ready */
        public void onPrepared(MediaPlayer player) {
            player.start();
        }
    }
}