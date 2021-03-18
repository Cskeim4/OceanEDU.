/**
 * Ocean Education App, Purpose: help kids learn the different animals in the ocean and their names
 * @author Clara Skeim
 * Version 1.0
 */
package com.example.oceanedu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
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
 * Main Activity Class that handles the main functions and creation of elements in the application
 */
public class MainActivity extends AppCompatActivity {

    //Declare various widgets
    ViewPager2 viewPager2;
    Button buttonAudio;
    MediaPlayer mediaPlayer;

    //Initialize the ocean adapter
    OceanAdapter adapter;

    //Declare a main view model
    MainViewModel mainViewModel;

    //Declare the firebase database instance and reference
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myref;

    //Create a tag to attach to the animal data
    public static final String OceanDataTag = "Ocean Animal Data";

    Context context;

    /**
     * The onCreate Method sets up the different application components and calls the db change method
     * @param savedInstanceState, saves the current state of the application
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get the content from the names and description arrays
        //s1 = getResources().getStringArray(R.array.Animal_Names);

        //Initialize the main view model and connect to the mainViewModel class
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Set the viewPager2 to the adapter and create a new OceanAdapter
        //When data is changed, notify the adapter, send the adapter the data
        viewPager2 = (ViewPager2) findViewById(R.id.viewPager);
        adapter = new OceanAdapter(this, mainViewModel);
        viewPager2.setAdapter(adapter);

        //Call the method in the adapter to notify of changes in data
        adapter.notifyDataSetChanged();

        //Call the method to change the data in the Firebase Db instance
        setupFirebaseDataChange();

        //Code to get a new key from the Db, the key is attached to the new animal object
        //The Db reference is used to send the values in the animal object to the Db
        /*
        String key = myref.push().getKey();
        // ---- set up the animal object
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

            /**
             * The onDataChange method clears the current list of animals then creates the new animal
             * The new animal is added to the array list and the adapter is notified of the changes
             * @param dataSnapshot, takes an image of the current state of the data in order to add on to it
             */
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("CIS3334", "Starting onDataChange()"); // debugging log
                mainViewModel.getAllAnimals().clear();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    Animal animal = data.getValue(Animal.class);
                    mainViewModel.animals.add(animal);
                }
                //Send a notification to the adapter when the dataset is changed/updated
                adapter.notifyDataSetChanged();
            }

            /**
             * The onCancelled method checks for errors in the database
             * @param databaseError, takes in the error and gives the message
             */
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("CIS3334", "onCancelled: ");
            }
        });

    }

}