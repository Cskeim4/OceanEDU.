package com.example.oceanedu;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * The Main View Model allows for separation of code functionality for better organization
 */
public class MainViewModel extends ViewModel {

    /**
     * Constructor for the main view model
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


    /**
     * Gets a specific animal in the animals array
     * @param position, used to get the specific animal at the specified index
     * @return, returns the animal at the position in the array given
     */
    public Animal getAnimal(int position){

        return animals.get(position);
    }

    /**
     * Gets all of the animals in the array list animals
     * @return, returns all of the animals in the list
     */
    public List<Animal> getAllAnimals(){

        return animals;
    }

    /**
     * Gets all of the audio files in the list
     * @return, returns all of the audio files
     */
    public int[] getAllAudio() {

        return audioFiles;
    }

    /**
     * Gets the audio file for a specific index
     * @param position, used to get the specific audio at the specified index
     * @return, returns the file for the specified position in the array
     */
    public int getAudio(int position) {

        return audioFiles[position];
    }

    /**
     * Gets all of the images in the list
     * @return, returns all of the image files in the list
     */
    public int[] getAllImages() {

        return images;
    }

    /**
     * Gets the image file for a specific index
     * @param position, used to get the specific image at the specified index
     * @return, returns the file for the specified position in the array
     */
    public int getImage(int position) {

        return images[position];
    }

}