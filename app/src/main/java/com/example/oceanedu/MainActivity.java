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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/image-slider-in-android-using-viewpager/

/**
 * Main Activity Class
 */
public class MainActivity extends AppCompatActivity {

    //Declare various widgets
    ViewPager2 viewPager2;
    Button buttonAudio;
    MediaPlayer mediaPlayer;
    OceanAdapter adapter;

    //Declare the firebase database instance and reference
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myref;
    //Create a tag to attach to the animal data
    public static final String OceanDataTag = "Ocean Animal Data";

    //Initialize array list of animal objects
    List<Animal> animals;

    //Initialize arrays to store the images and audio files
    int audioFiles [] = {R.raw.dolphin, R.raw.seahorse, R.raw.seaturtle,
            R.raw.shark, R.raw.octopus, R.raw.jellyfish, R.raw.lobster,
            R.raw.starfish, R.raw.orca, R.raw.mantaray};

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
        //s1 = getResources().getStringArray(R.array.Animal_Names);

        //Declare new array list of animals
        animals =  new ArrayList();

        // Set the viewPager2 to the adapter and create a new OceanAdapter
        //When data is changed, notify the adapter, send the adapter the data
        viewPager2 = (ViewPager2) findViewById(R.id.viewPager);
        adapter = new OceanAdapter(this, animals, images, audioFiles);
        viewPager2.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //Array to store the audio files for the animal name pronunciations
        //?? not working
        /*audioFiles = new int[] {R.raw.dolphin, R.raw.seahorse, R.raw.seaturtle,
                R.raw.shark, R.raw.octopus, R.raw.jellyfish, R.raw.lobster,
                R.raw.starfish, R.raw.orca, R.raw.mantaray};

        //Set the media player to get the array of audio files
        mediaPlayer = MediaPlayer.create(this, audioFiles[0]);
        */

        //Call the method to change the data in the Firebase Db instance
        setupFirebaseDataChange();

        //Code to get a new key from the Db, the key is attached to the new animal object
        //The Db reference is used to send the values in the animal object to the Db

        /*
        String key = myref.push().getKey();
        // ---- set up the fish object
        Animal animal = new Animal(key, "Animal Name", "Fun Fact");
        // ---- write the vote to Firebase
        myref.child(key).setValue(animal);
         */

    }

    /**
     * Method to notify the FirebaseDatabase of changes to data
     */
    private void setupFirebaseDataChange() {
        //Get the database instance and set the reference
        firebaseDatabase = FirebaseDatabase.getInstance();
        myref = firebaseDatabase.getReference(OceanDataTag);
        myref.addValueEventListener(new ValueEventListener() {
            //When new data is added to the list create a new animal object and add it to the array list
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("CIS3334", "Starting onDataChange()"); // debugging log
                animals.clear();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Animal animal = data.getValue(Animal.class);
                    animals.add(animal);
                }
                //Send a notification to the adapter when the dataset is changed/updated
                adapter.notifyDataSetChanged();
            }
            //Method to check for database errors
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });

    }

}