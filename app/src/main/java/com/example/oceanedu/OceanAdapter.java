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

    //Set the firebase instance
    OceanAdapter (FirebaseDatabase firebaseDatabase){

        this.firebaseDatabase = firebaseDatabase;
    }

    //Declare array and variables
    List<Animal> animals;
    int images[];
    Context context;
    int audioFiles[];

    //Initialize the media player
    MediaPlayer mediaPlayer;

    /**
     * Constructor for creating an ocean adapter
     * @param ct
     * @param inAnimals
     * @param img
     */
    public OceanAdapter(Context ct, List<Animal> inAnimals, int img[], int audio[]){
        context = ct;
        animals  = inAnimals;
        images = img;
        audioFiles = audio;
    }

    /**
     * onCreateViewHolder method for the OceanViewHolder
     * @param parent
     * @param viewType
     * @return
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
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull OceanViewHolder holder, int position) {
        //Store returned selected animal in the text view(widget) holder
        holder.textViewName.setText(animals.get(position).getName());
        holder.textViewFunFact.setText(animals.get(position).getFunFact());
        holder.imageViewAnimal.setImageResource(images[position]);

        //The audio button and let the DB know about data changes
        setupAudioButton(holder,position);
    }

    /**
     * Method for Handling the Audio Button and Media Player
     */
    //For audio
    private void setupAudioButton(OceanViewHolder holder, int position) {
        holder.buttonAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set the media player to get the array of audio files
                mediaPlayer = MediaPlayer.create(context, audioFiles[position]);
                mediaPlayer.start();
            }
        });
    }

    /**
     * getItemCount method for the OceanViewHolder, gets the images array
     * @return images
     */
    @Override
    public int getItemCount() {
        //Retrieve the animals from the images array
        return animals.size();
    }
}
