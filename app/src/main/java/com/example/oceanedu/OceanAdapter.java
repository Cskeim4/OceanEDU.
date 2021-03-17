package com.example.oceanedu;

import android.app.Application;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

/**
 * The OceanAdapter class manages the components in the view pager
 * This class inherits from the RecyclerView adapter
 */
public class OceanAdapter extends RecyclerView.Adapter<OceanViewHolder> {

    //Declare firebaseDatabase
    FirebaseDatabase firebaseDatabase;

    //Declare a main view model
    MainViewModel mainViewModel;

    //Set the firebase instance
    OceanAdapter (FirebaseDatabase firebaseDatabase){

        this.firebaseDatabase = firebaseDatabase;
    }

    Context context;

    //Initialize the media player
    MediaPlayer mediaPlayer;

    /**
     * Constructor for creating the ocean adapter
     * @param ct, takes in the context and sets it
     * @param inMainViewModel, brings in the main view model
     */
    public OceanAdapter(Context ct, MainViewModel inMainViewModel){
        context = ct;
        mainViewModel = inMainViewModel;
    }

    /**
     * onCreateViewHolder method for the OceanViewHolder, sets up the view
     * @param parent, takes in the view group parent
     * @param viewType, takes in the view type
     * @return, returns the newly created ocean view holder
     */
    @NonNull
    @Override
    public OceanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.animal_row, parent, false);

        //return the new view for the specific order
        OceanViewHolder holder = new OceanViewHolder(view);
        return new OceanViewHolder(view);
    }

    /**
     * onBindViewHolder method for the OceanViewHolder
     * @param holder, stores the items in the view holder for each specific widget
     * @param position, gets the position of the specific item in the list
     */
    @Override
    public void onBindViewHolder(@NonNull OceanViewHolder holder, int position) {
        //Store returned selected animal in the text view(widget) holder
        //Access components through the main view model variable
        Animal animal = mainViewModel.getAnimal(position);
        holder.textViewName.setText(animal.getName());
        holder.textViewFunFact.setText(animal.getFunFact());
        holder.imageViewAnimal.setImageResource(mainViewModel.getImage(position));

        //The audio button and let the DB know about data changes
        setupAudioButton(holder,position);
    }


    /**
     * Method for Handling the Audio Button and Media Player
     * @param holder, finds the holder the desired item is in
     * @param position, get the position of the specific audio file
     */
    private void setupAudioButton(OceanViewHolder holder, int position) {
        holder.buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set the media player to get the array of audio files
                mediaPlayer = MediaPlayer.create(context, mainViewModel.getAudio(position));
                mediaPlayer.start();
            }
        });
    }

    /**
     * getItemCount method gets the size/length of the animals array
     */
    @Override
    public int getItemCount() {
        //Retrieve the animals from the animals array
        return mainViewModel.getAllAnimals().size();
    }
}
