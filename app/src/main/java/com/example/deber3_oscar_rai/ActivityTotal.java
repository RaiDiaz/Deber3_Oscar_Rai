package com.example.deber3_oscar_rai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityTotal extends AppCompatActivity {

    private ModeloItemLists mStatusTracker = ModeloItemLists.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
    }
}