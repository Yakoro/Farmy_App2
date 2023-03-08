package com.farminc.france.farmy.controller;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

import android.os.Bundle;

import org.json.JSONObject;
import com.farminc.france.farmy.R;
import java.io.IOException;
import java.net.URI;
import org.json.JSONObject;
import java.io.*;;
import java.net.*;
import java.nio.charset.*;
import org.json.*;
import android.util.JsonReader;
import android.net.
public class SynchroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchro);

        File fichierFarmy = new File("farmy.json");

        if (!fichierFarmy.exists()) {
            try {
                fichierFarmy.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*URL url = null;
            try {
                url = new URL("monsiteweb");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            String texte = null;
            try {
                texte = (String) url.getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(texte);
            */
            String url = "http://ip.jsontest.com/";  // example url which return json data
            JsonReader reader = new JsonReader( new StringReader(JSON));       // To ReadJson in order to read from url.
            JSONObject json = null; // calling method in order to read.
            try {
                reader.beginObject();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String aJsonString = fichierFarmy.getString("STRINGNAME");
            System.out.println(json.toString());            // simple for printing.

        }
    }
}