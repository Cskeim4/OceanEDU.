package com.example.oceanedu;

import android.media.Image;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OceanViewHolder extends RecyclerView.ViewHolder {
    TextView textViewName;
    TextView textViewFunFact;
    Image imageViewAnimal;
    Button buttonAudio;

    ImageView imageView;

    public OceanViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);

        textViewName = itemView.findViewById(R.id.textViewName);
        textViewFunFact = itemView.findViewById(R.id.textViewFunFact);
    }
}
