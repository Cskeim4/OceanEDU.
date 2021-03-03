package com.example.oceanedu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images [] = {R.drawable.dolphin, R.drawable.seahorse, R.drawable.seaturtle,
            R.drawable.shark, R.drawable.octopus};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.Animal_Names);
        s2 = getResources().getStringArray(R.array.description);

        OceanAdapter oceanAdapter = new OceanAdapter(this, s1, s2, images);
        recyclerView.setAdapter(oceanAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}