package com.example.appmarvel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.description);

        TextView texte = findViewById(R.id.texte);
        TextView bio = findViewById(R.id.bio);

        Intent intent = getIntent();


        texte.setText(intent.getStringExtra("nom"));
        bio.setText(intent.getStringExtra("texte"));

    }
}
