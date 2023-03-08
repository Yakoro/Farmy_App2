package com.farminc.france.farmy.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.File;
import java.io.IOException;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.farminc.france.farmy.R;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Si l'écran est touché
        ConstraintLayout mMainLayout = (ConstraintLayout) findViewById(R.id.main_layout);
        mMainLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                File fichier = new File("info_user.json");

                if (!fichier.exists()) {
                    try {
                        fichier.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //Start InfoUserActivity
                    Intent infoUserActivityIntent = new Intent(MainActivity.this, InfoUserActivity.class);
                    startActivity(infoUserActivityIntent);
                    //info.put("Name","");
                } //else if () {

                //}
                return false;
            }
        });
    }
}