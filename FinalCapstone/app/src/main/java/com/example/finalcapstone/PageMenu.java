package com.example.finalcapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PageMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_menu);
    }

    public void threeFour(View view) {
        Intent i = new Intent(this, ThreeFour.class);
        startActivity(i);
    }


    public void sixTwo(View view) {
        Intent i = new Intent(this, SixTwo.class);
        startActivity(i);
    }

    public void twelve(View view) {
        Intent i = new Intent(this, Twelve.class);
        startActivity(i);
    }

}