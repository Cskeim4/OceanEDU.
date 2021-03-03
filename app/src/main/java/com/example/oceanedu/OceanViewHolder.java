package com.example.oceanedu;

import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OceanViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName;
    TextView textViewFunFact;
    Image imageViewAnimal;
    Button buttonAudio;

    public OceanViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewFunFact = itemView.findViewById(R.id.textViewFunFact);
    }
}
