package com.example.oceanedu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OceanAdapter extends RecyclerView.Adapter<OceanAdapter> {

    String data1[], data2[];
    int images[];
    Context context;

    public OceanAdapter(Context ct, String s1[], String s2[], int img[]){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;


    }

    @NonNull
    @Override
    public OceanAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.animal_row, parent, false);
        //return the new view for the specific order
        return new OceanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OceanAdapter holder, int position) {
        //get the item position from the mainViewModel then connect it to a xml widget
        String selectedOrder = MainViewModel.getOrderItem(position);
        //Store returned selected animal in the text view(widget) holder
        holder.textViewName.setText(data1[position]);
        holder.textViewFunFact.setText(data2[position]);
        holder.imageViewAnimal.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        //Retrieve the number of animals from the mainViewModel
        return images.length;
    }
}
