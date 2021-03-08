package com.example.oceanedu;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

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
    String data1[], data2[];
    int images[];
    Context context;

    /**
     * Constructor for creating an ocean adapter
     * @param ct
     * @param s1
     * @param s2
     * @param img
     */
    public OceanAdapter(Context ct, String s1[], String s2[], int img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
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
        holder.textViewName.setText(data1[position]);
        holder.textViewFunFact.setText(data2[position]);
        holder.imageViewAnimal.setImageResource(images[position]);
    }

    /**
     * getItemCount method for the OceanViewHolder, gets the images array
     * @return images
     */
    @Override
    public int getItemCount() {
        //Retrieve the animals from the images array
        return images.length;
    }
}
