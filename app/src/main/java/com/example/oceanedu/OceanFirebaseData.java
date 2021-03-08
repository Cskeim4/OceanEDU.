package com.example.oceanedu;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.List;

/**
 *
 */
public class OceanFirebaseData {

    //Declare a reference to the firebase database instance
    //Declare a tag for the ocean animal data stored on the db instance
    DatabaseReference myref;
    public static final String OceanDataTag = "Ocean Animal Data";
    String s1[];

    /**
     *
     * @return
     */
    public DatabaseReference open(){
        //Write message to DB
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myref = database.getReference(OceanDataTag);
        //Get the array of animal names from the strings xml file
        s1 = getResources().getStringArray(R.array.Animal_Names);
        return myref;
    }

    /**
     *
     */
    public void close(){
    }

    /**
     *
     * @return
     */
    public Array<Animal_Names> getAllAnimals() {
        return Animal_Names;
    }

    /**
     *
     * @param position
     * @return
     */
    public Animal getAnimals(Integer position) {
        return Animal_Names.get(position);
    }

    /**
     *
     * @return
     */
    public Integer getNumberOfAnimals() {
        return Animal_Names.size();
    }
}
