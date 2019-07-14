package com.example.andelaphase1challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get the buttons
        findViewById(R.id.alc_button).setOnClickListener(this);
        findViewById(R.id.profile_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alc_button:
                Toast.makeText(getApplicationContext(),"Fetching Andela's about page",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, about_activity.class));
                break;
            case R.id.profile_btn:
                Toast.makeText(getApplicationContext(), "Showing My Profile", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, profileActivity.class));
                break;
        }
    }
}

