package com.example.finalcapstone;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.View;

import com.example.finalcapstone.ContactInformation;
import com.example.finalcapstone.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Info(View view) {
        Intent i = new Intent(this, ContactInformation.class);
        startActivity(i);
    }

    public void pageMenu(View view) {
        Intent i = new Intent(this, PageMenu.class);
        startActivity(i);
    }
}