package com.exempleapp.firstapp.Ads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.exempleapp.firstapp.MainActivity;
import com.exempleapp.firstapp.R;

public class pb_internet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pb_internet);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (constant.isNetworkAvailable(pb_internet.this)) {
                    Intent intent = new Intent(pb_internet.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // La connexion Internet n'est pas disponible

                }
            }
        });

    }
}