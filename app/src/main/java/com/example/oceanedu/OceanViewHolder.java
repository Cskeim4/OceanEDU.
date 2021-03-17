package com.example.oceanedu;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * OceanViewHolder class, displays the different UI components
 */
public class OceanViewHolder extends RecyclerView.ViewHolder {
    //Declare the UI components
    TextView textViewName;
    TextView textViewFunFact;
    ImageView imageViewAnimal;
    Button buttonAudio;

    //Declare the media player
    MediaPlayer mediaPlayer;

    /**
     * OceanViewHolder Constructor for creating the view holder and connecting various UI widgets
     * @param itemView, takes in the specific view for each item in the created view
     */
    public OceanViewHolder(@NonNull View itemView) {
        super(itemView);

        //Connect variables to the widgets in the display xml file
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewFunFact = itemView.findViewById(R.id.textViewFunFact);
        imageViewAnimal = itemView.findViewById((R.id.imageViewAnimal));
        buttonAudio = itemView.findViewById(R.id.buttonAudio);

    }
}
