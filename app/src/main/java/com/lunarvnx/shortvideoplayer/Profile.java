package com.lunarvnx.shortvideoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        // Action Bar Back
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    // Click Back Button Action Bar
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}