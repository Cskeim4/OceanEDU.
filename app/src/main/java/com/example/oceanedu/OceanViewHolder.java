package com.example.oceanedu;

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

    /**
     * OceanViewHolder Constructor for creating the view holder and various UI widgets
     * @param itemView
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
