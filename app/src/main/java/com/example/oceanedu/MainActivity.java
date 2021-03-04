/**
 * Ocean Education App, Purpose: help kids learn the different animals in the ocean and their names
 * @author Clara Skeim
 * Version 1.0
 */
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

/**
 * Main Activity Class
 */
public class MainActivity extends AppCompatActivity {

    //Declare various widgets
    ViewPager2 viewPage;
    Button buttonAudio;
    MediaPlayer mediaPlayer;

    //Initialize arrays
    String s1[], s2[];
    int audioFiles [];

    int images [] = {R.drawable.dolphin, R.drawable.seahorse, R.drawable.seaturtle,
            R.drawable.shark, R.drawable.octopus, R.drawable.jellyfish, R.drawable.lobster,
            R.drawable.starfish, R.drawable.orca, R.drawable.mantaray};


    /**
     * onCreate Method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get the content from the names and description arrays
        s1 = getResources().getStringArray(R.array.Animal_Names);
        s2 = getResources().getStringArray(R.array.description);

        // Set up the ViewPager Adapter similar to other RecycleView Adapters
        viewPage = (ViewPager2) findViewById(R.id.viewPager);
        OceanAdapter adapter = new OceanAdapter(this, s1, s2, images);
        viewPage.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //Array to store the audio files for the animal name pronunciations
        audioFiles = new int[] {R.raw.dolphin, R.raw.seahorse, R.raw.seaturtle,
                R.raw.shark, R.raw.octopus, R.raw.jellyfish, R.raw.lobster,
                R.raw.starfish, R.raw.orca, R.raw.mantaray};

        //Set the media player to get the array of audio files
        mediaPlayer = MediaPlayer.create(this, audioFiles[0]);

    }

    /**
     * Method for Handling the Audio Button and Media Player
     */
    //For audio
    private void setupAudioButton() {
        buttonAudio = findViewById(R.id.buttonAudio);
        buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
    }
}