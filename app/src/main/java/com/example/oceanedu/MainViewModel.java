package com.example.oceanedu;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class MainViewModel extends ViewModel {


    /**
     *
     */
    public MainViewModel() {

    }
    //Initialize array list of animal objects
    List<Animal> animals = new ArrayList();

    //Initialize arrays to store the images and audio files
    int audioFiles[] = {R.raw.dolphin, R.raw.seahorse, R.raw.seaturtle,
            R.raw.shark, R.raw.octopus, R.raw.jellyfish, R.raw.lobster,
            R.raw.starfish, R.raw.orca, R.raw.mantaray};

    int images[] = {R.drawable.dolphin, R.drawable.seahorse, R.drawable.seaturtle,
            R.drawable.shark, R.drawable.octopus, R.drawable.jellyfish, R.drawable.lobster,
            R.drawable.starfish, R.drawable.orca, R.drawable.mantaray};


    public Animal getAnimal(int position){
        return animals.get(position);
    }

    public List<Animal> getAllAnimals(){
        return animals;
    }

    public int getAudio() {

    }

    getImage() {

    }

}